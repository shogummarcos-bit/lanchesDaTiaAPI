package com.apilanchesdatia.api.repository;

public class ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findByAtivogrue();
    Cliente findByEmail(String email);
}
