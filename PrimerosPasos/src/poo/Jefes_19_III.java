package poo;

public interface Jefes_19_III extends Trabajadores_19_II {	//con extends creamos también una jerarquía entre interfaces TRabajadores>Jefes
	
	String tomar_decisiones(String decision); //es pública y abstracta pero no hace falta ponerlo, en Interface se sobrenetiende.
	

}
