package me.bj.jpashop.service;

import lombok.RequiredArgsConstructor;
import me.bj.jpashop.domain.item.Book;
import me.bj.jpashop.domain.item.Item;
import me.bj.jpashop.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public Item updateItem(Long itemId, Book book){
        Item one = itemRepository.findOne(itemId);
        one.setName(book.getName());
        return one;
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
