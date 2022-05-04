package dao;

import java.sql.Connection;
import java.util.Collection;

import entidades.Metal;

public class MetalDAO implements operacionesCRUD<Metal> {
	Connection conex;

	public MetalDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Metal elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Metal elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Metal buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Metal> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Metal elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Metal elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	

}