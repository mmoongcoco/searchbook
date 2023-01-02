package com.miniproject.searchbook.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Entity
@Table(name = "TBL_BOOK")
@Getter
@NoArgsConstructor
public class Book extends Period{
    /* Book entity 필요 없을 것으로 예상됨. */
    @Id @GeneratedValue @NotNull
    private Long bookId;
    @NotNull
    private String bookTitle;
    private String bookThumbnail;
    private String bookContents;
    private String bookISBN;
    @NotNull
    private String bookAuthors;
    private String bookPublisher;
    @NotNull
    private LocalDateTime bookDateTime;
    private int bookPrice;
    private int bookSalePrice;

}
