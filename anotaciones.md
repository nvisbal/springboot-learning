https://www.youtube.com/watch?v=ksLYIavT2L0
Esterotipos de Springboot

JPA
@Id=Atributo que representa el id de la entidad
@GeneratedValue(strategy = GenerationType.AUTO)=Tipo de generación del id único
@Column(name = "name", length = 50)=Sirve para iddentificar que columna representa el atributo indicado
@Entity=Representa una entidad en la base de datos

Spring es manejado como singletong

@Configuration=Indica que la clase es para configuraciones
@Repository= Usado para identificar que la clase es usada para el acceso a repositorio de información.
@Qualifier=Identificación de un bean cuando hay varias instancia a la misma implementación.
@Service=Estereotipo para identificar que es una clase de lógica de negocio.
@Autowired=Traer una instancia definida por un estereotipo. Busca un bean ya instanciado de la clase a la que hace referencia.
@Bean=Declarar y tener una instancia de ámbito singleton
@Controller=Identifica que la clase es un controlador
@RestController=Identifica que la clase es un controlador de tipo Rest
@RequestParam=Indica un parámetro a recibir en el url  /listar?name=xxx
@RequestBody=Transforma el objeto recibido json en un objeto

@PathVariable=Indica que se va a recibir una variable en el 
# @DeleteMapping(value="/{id}")
	public void insert (@PathVariable("id") Integer id) {
		repositorio.deleteById(id);	
	}

Revisar en Mitocode java 7 sección genericos

h2. Controladores
    @GetMapping("/greeting")
	public String greeting(			
			@RequestParam(name="name", required=false, defaultValue="World") String name, 
			@RequestParam(name="lastname", required=false, defaultValue="Visbal") String lastname,
			Model model) {
                ...
                return "nombre-recurso"
            }

    # Model dentro del controlador @Controller sirve para agregar variables para que sean recuperados en la vista.
    # Al retornar un string se va a buscar una vista llamada "nombre-recurso" dentro de "src/main/resources/templates/nombre-recurso.html