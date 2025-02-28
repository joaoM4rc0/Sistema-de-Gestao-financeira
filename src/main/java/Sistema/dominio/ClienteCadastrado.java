package Sistema.dominio;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClienteCadastrado {
    private String name;
    private Integer id;
}
