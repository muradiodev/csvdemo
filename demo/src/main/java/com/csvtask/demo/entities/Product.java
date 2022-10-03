package com.csvtask.demo.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private Long id;

    @CsvBindByName(column = "source")
    private String source;
    @CsvBindByName(column = "codeListCode")
    private String codeListCode;
    @CsvBindByName(column = "code")
    @Column(unique = true)
    private String code;
    @CsvBindByName(column = "displayValue")
    private String displayValue;
    @CsvBindByName(column = "longDescription")
    private String longDescription;
    @CsvBindByName(column = "fromDate")
    private String fromDate;
    @CsvBindByName(column = "toDate")
    private String toDate;
    @CsvBindByName(column = "sortingPriority")
    private String sortingPriority;
}
