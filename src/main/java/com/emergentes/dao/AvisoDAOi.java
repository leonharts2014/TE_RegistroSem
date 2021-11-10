
package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOi extends ConexionDB implements AvisoDAO{

    @Override
    public void insert(Aviso aviso) throws Exception {
        try{
            this.conectar();
            String sql = "insert into seminarios(titulo,exposicion,fecha,hora,cupo)values(?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getTitulo());
            ps.setString(2, aviso.getExposicion());
            ps.setString(3, aviso.getFecha());
            ps.setString(4, aviso.getHora());
            ps.setInt(5, aviso.getCupo());
            
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Aviso aviso) throws Exception {
        try{
            this.conectar();
            String sql = "update seminarios set titulo = ?, exposicion = ?,fecha = ?, hora = ?,cupo = ? where id= ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getTitulo());
            ps.setString(2, aviso.getExposicion());
            ps.setString(3, aviso.getFecha());
            ps.setString(4, aviso.getHora());
            ps.setInt(5, aviso.getCupo());
            ps.setInt(6, aviso.getId());
            
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar();
            String sql = "DELETE from seminarios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1,id);
            //Ejecutar la consulta
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public Aviso getById(int id) throws Exception {
       Aviso avi = new Aviso();
        try{
              this.conectar();
              
              String sql="select * from seminarios where id=?";
              PreparedStatement ps = this.conn.prepareStatement(sql);
              ps.setInt(1, id);
              ResultSet rs = ps.executeQuery();
              
              if(rs.next()){
                  avi.setId(rs.getInt("id"));
                  avi.setTitulo(rs.getString("titulo"));
                  avi.setExposicion(rs.getString("exposicion"));
                  avi.setFecha(rs.getString("fecha"));
                  avi.setHora(rs.getString("hora"));
                  avi.setCupo(rs.getInt("cupo"));
              }
        }catch(Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Aviso> getAll() throws Exception {
         List<Aviso> lista = null;
        try{
            this.conectar();
            String sql = "select * from seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Aviso>();
            while(rs.next()){
                Aviso avi = new Aviso();
                avi.setId(rs.getInt("id"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setExposicion(rs.getString("exposicion"));
                avi.setFecha(rs.getString("fecha"));
                avi.setHora(rs.getString("hora"));
                avi.setCupo(rs.getInt("cupo"));
                
                lista.add(avi);
            }
        }catch(Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
        return lista;
    }
   
}
