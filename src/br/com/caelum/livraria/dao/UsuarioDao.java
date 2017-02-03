package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

public class UsuarioDao {
	
	public boolean existe(Usuario usuario){
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		TypedQuery<Usuario> query = (TypedQuery<Usuario>) em.createQuery(
				"select u from Usuario u where "
				+ "u.email = :pEmail and "
				+ "u.senha = :pSenha");
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		try{
			query.getSingleResult();
		}catch(NoResultException e){
			return false;
		}
				
		em.close();
		
		return true;
	}

}
