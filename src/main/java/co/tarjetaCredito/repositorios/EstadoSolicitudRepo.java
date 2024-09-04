package co.tarjetaCredito.repositorios;

import org.springframework.stereotype.Repository;

import co.tarjetaCredito.entidades.EstadoSolicitud;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface EstadoSolicitudRepo extends CrudRepository<EstadoSolicitud,Integer>{

    
} 
