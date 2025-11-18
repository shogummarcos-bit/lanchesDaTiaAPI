package com.apilanchesdatia.api.repository;

public class ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findByAtivogrue();
    Clinte finitdByEmail(String enemail);
}
