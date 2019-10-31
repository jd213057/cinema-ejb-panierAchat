package fr.gtm.entities;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="film_acteur")
public class Role {
private String role;

public Role() {

}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return role;
}



}
