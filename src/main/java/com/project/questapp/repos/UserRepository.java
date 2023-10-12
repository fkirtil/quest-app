package com.project.questapp.repos;

import com.project.questapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { //Repositorynin hangi objeyi kullancağını, ve id'sinin tipini vermemiz gerekiyor. Jpa
//repolar bizim database'e istek(query) atmamızın methodlu halleri gibi düşünebiliriz. findAll = select * from. query i bizim için arkada yazıp gönderen methodlar mevcut.

}
