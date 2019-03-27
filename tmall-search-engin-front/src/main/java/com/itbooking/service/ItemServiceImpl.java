package com.itbooking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.itbooking.repository.ItemRepository;
import com.itbooking.vo.Item;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    
    //@Autowired
    //private TransportClient transportClient;

    @Override
    public long count() {
        return itemRepository.count();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteById(String itemId) {
        // itemRepository.delete(item);
        itemRepository.deleteById(itemId);
    }

    @Override
    public Iterable<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getByName(String name) {
        List<Item> list = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("title", name);
        Iterable<Item> iterable = itemRepository.search(matchQueryBuilder);
        iterable.forEach(e->list.add(e));
        return list;
    }
    

    public Page<Item> pageQueyAll(String keyword,int pageNo,int pageSize){
    	PageRequest pageable = PageRequest.of(pageNo, pageSize);
    	return  itemRepository.search(QueryBuilders.multiMatchQuery(keyword,"title","sellPoint"), pageable);
    }
    

    @Override
    public AggregatedPage<Item>  pageQuery(Integer pageNo, Integer pageSize, String keyword) {
    	// 设置排序
    	Sort sort = Sort.by(Order.desc("date"),Order.asc("price"));
    	
    	PageRequest pageable = PageRequest.of(pageNo, pageSize,sort);

        String preTag = "<i class='skeyon'>";//google的色值
        String postTag = "</i>";
        
        
        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                //withQuery(QueryBuilders.matchQuery("title", keyword)).
                //withQuery(QueryBuilders.matchQuery("sellpoint", keyword)).
        		withQuery(QueryBuilders.multiMatchQuery(keyword,"title","sellPoint"))
        		.withHighlightFields(
                		new HighlightBuilder.Field("title").preTags(preTag).postTags(postTag),
                        new HighlightBuilder.Field("sellPoint").preTags(preTag).postTags(postTag))
        		.withPageable(pageable).build();
        
        
        // 高亮字段
        AggregatedPage<Item> ideas = elasticsearchTemplate.queryForPage(searchQuery, Item.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
            	
            	// 获取搜索的总记录数
            	long totalHits = response.getHits().getTotalHits();
            	
            	// 获取权重比分
            	float maxScore = response.getHits().getMaxScore();
            	
            	System.out.println("一共命中了........" + totalHits +"===="+maxScore);
            	
                List<Item> items = new ArrayList<>();
                for (SearchHit searchHit : response.getHits()) {
                    if (response.getHits().getHits().length <= 0) {
                        return null;
                    }
                    
                    Item item = new Item();
                    //name or memoe
                    HighlightField title = searchHit.getHighlightFields().get("title");
                    if (title != null) {
                        item.setTitle(title.fragments()[0].toString());
                    }else {
                        item.setTitle(String.valueOf(searchHit.getSourceAsMap().get("title")));
                    }
                    
                    HighlightField ideaContent = searchHit.getHighlightFields().get("sellPoint");
                    if (ideaContent != null) {
                        item.setSellPoint(ideaContent.fragments()[0].toString());
                    }else {
                        item.setSellPoint(String.valueOf(searchHit.getSourceAsMap().get("sellPoint")));
                    }
                    
                    item.setImg(String.valueOf(searchHit.getSourceAsMap().get("img")));
                    item.setPrice(Float.parseFloat(String.valueOf(searchHit.getSourceAsMap().get("price"))));
                    item.setId(String.valueOf(searchHit.getSourceAsMap().get("id")));
                    item.setDate(new Date(Long.parseLong(String.valueOf(searchHit.getSourceAsMap().get("date")))));

                    items.add(item);
                }
                
               return new AggregatedPageImpl<>((List<T>) items,pageable,totalHits,maxScore);
            }
        });
        
        return ideas;
    }


}