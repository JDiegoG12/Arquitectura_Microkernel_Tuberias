package co.unicauca.microkernel.gestionproyectos.core.plugin.manager;
import java.lang.reflect.Constructor; 

/** 
 * @file PluginFactory.java
 * @brief Clase encargada de la creación de plugins para la gestión de proyectos.
 *
 * Esta clase permite la creación dinámica de instancias de plugins que implementan la interfaz
 * IProjectRepositoryPlugin utilizando reflexión.
 */
public class PluginFactory {    

    /**
     * @brief Crea una instancia de un plugin según el nombre de clase proporcionado.
     *
     * El método utiliza reflexión para crear una instancia de la clase especificada
     * que debe implementar la interfaz IProjectRepositoryPlugin.
     *
     * @param className Nombre de la clase del plugin a crear (sin el paquete completo).
     * @return Instancia del plugin que implementa la interfaz IProjectRepositoryPlugin.
     * @throws Exception Si ocurre algún error durante la creación del objeto.
     */
    public static IProjectRepositoryPlugin createPlugin(String className) throws Exception { 
        className = "co.unicauca.microkernel.gestionproyectos.access." + className; 
        Class<?> clazz = Class.forName(className); 
        Constructor<?> constructor = clazz.getConstructor();
        return (IProjectRepositoryPlugin) constructor.newInstance(); 
    } 
}
