package pojo;

import lombok.*;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/18
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Books {

    private int bookID;
    private String bookName;
    private String detail;
    private int bookCounts;
}
