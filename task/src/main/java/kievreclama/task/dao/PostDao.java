/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.entity.Post;

/**
 *
 * @author firsov
 */
public interface PostDao {
    
    void add(Post post) throws SQLException;
    void delete(Post post) throws SQLException;
    void update(Post post) throws SQLException;
    Post find(Integer id) throws SQLException;
    List<Post> list() throws SQLException;
}
