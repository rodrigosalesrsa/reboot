package io.github.rodrigosalesrsa.domain.repository;

import io.github.rodrigosalesrsa.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static final String SELLECT_ALL = "SELECT * FROM CLIENTE";
    private static final String UPDATE = "update set name= ? where id = ?";
    private static final String DELETE = "delete from CLIENTE where id = ? ";
    private static  String INSERT = "insert into cliente (name) values (?)";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT,new Object[]{cliente.getName()});
        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getName(), cliente.getId()});
        return cliente;
    }

    public void delete(Cliente cliente){
        delete(cliente.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update( DELETE, new Object[]{id});
    }


    public List<Cliente> listarTodos(){
        return jdbcTemplate.query(SELLECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(resultSet.getInt("id"),resultSet.getString("name"));
            }
        });

    }

}
