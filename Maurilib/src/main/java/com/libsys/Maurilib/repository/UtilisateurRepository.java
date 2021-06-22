package com.libsys.Maurilib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.libsys.Maurilib.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	Utilisateur findByEmail(String email);
	Utilisateur findByEmailAndCode(String email,String code);
	
	@Query(value="Select * from utilisateurs where nom like %?1% or email like %?1% or telephone like %?1%",nativeQuery=true)
	List<Utilisateur> findUser(String cle);
	}
