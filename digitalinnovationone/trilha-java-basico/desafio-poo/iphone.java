// Interface Iphone
public interface Iphone {
    void executarApp();
}

// Classe para o Reprodutor Musical
public class ReprodutorMusical implements Iphone {
    @Override
    public void executarApp() {
        System.out.println("Abrindo o Reprodutor Musical...");
        tocar();
        pausar();
        selecionarMusica("Imagine - John Lennon");
    }

    public void tocar() {
        System.out.println("Reproduzindo música...");
    }

    public void pausar() {
        System.out.println("Música pausada.");
    }

    public void selecionarMusica(String musica) {
        System.out.println("Música selecionada: " + musica);
    }
}

// Classe para o Aparelho Telefônico
public class AparelhoTelefonico implements Iphone {
    @Override
    public void executarApp() {
        System.out.println("Abrindo o Aparelho Telefônico...");
        ligar("123456789");
        atender();
        iniciarCorreioVoz();
    }

    public void ligar(String numero) {
        System.out.println("Ligando para o número: " + numero);
    }

    public void atender() {
        System.out.println("Atendendo chamada...");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o correio de voz...");
    }
}

// Classe para o Navegador na Internet
public class NavegadorInternet implements Iphone {
    @Override
    public void executarApp() {
        System.out.println("Abrindo o Navegador na Internet...");
        exibirPagina("https://www.exemplo.com");
        adicionarNovaAba();
        atualizarPagina();
    }

    public void exibirPagina(String url) {
        System.out.println("Exibindo página: " + url);
    }

    public void adicionarNovaAba() {
        System.out.println("Nova aba adicionada.");
    }

    public void atualizarPagina() {
        System.out.println("Página atualizada.");
    }
}

// Classe principal para testar
public class TesteIphone {
    public static void main(String[] args) {
        Iphone appMusical = new ReprodutorMusical();
        Iphone appTelefonico = new AparelhoTelefonico();
        Iphone appNavegador = new NavegadorInternet();

        // Executando os aplicativos
        appMusical.executarApp();
        appTelefonico.executarApp();
        appNavegador.executarApp();
    }
}