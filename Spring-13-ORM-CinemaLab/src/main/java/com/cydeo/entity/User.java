package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_account")
public class User extends BaseEntity{
private String email;
private String password;
private String username;

@OneToOne (fetch = FetchType.EAGER)
@JoinColumn(name = "account_details_id")
private Account account;



}
