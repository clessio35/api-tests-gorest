package api.test.steps;

import java.io.IOException;

import api.test.pages.GoRestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GoRestSteps {
	
	GoRestPage go = new GoRestPage();
	


	@Given("que acesso a API {string}")
	public void que_acesso_a_api(String url) throws IOException {
		go.accessApi(url);
	}

	@When("realizo uma request GET para {string}")
	public void realizo_uma_request_get_para(String endpoint) throws IOException {
	    go.requestGETMethod(endpoint);
	}

	@Then("eu valido a resposta da página {string} com a lista de usuários")
	public void eu_valido_a_resposta_da_página_com_a_lista_de_usuários(String page) throws IOException {
	    go.validateResponsePageWithListUsers(page);
	}
	
	@When("realizo uma request GET para {string} e id")
	public void realizo_uma_request_get_para_e_id(String endpoint) throws IOException {
	    go.requestGETMethodWithId(endpoint);
	}

	@Then("eu valido os dados do usuário específico")
	public void eu_valido_os_dados_do_usuário_específico() throws IOException {
	    go.validateResponseUserSpecific();
	}

	@Then("eu valido que o erro retornado tem o status code {string}")
	public void eu_valido_que_o_erro_retornado_tem_o_status_code(String status) throws IOException {
	    go.validateResponseWithErrorUserNonExistent(status);
	}

	@When("realizo uma request POST para {string} com {string}, {string}, {string} e {string}")
	public void realizo_uma_request_post_para_com_e(String string, String string2, String string3, String string4, String string5) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("eu valido que a criação foi bem-sucedida com status {string}")
	public void eu_valido_que_a_criação_foi_bem_sucedida_com_status(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("eu valido o erro retornado com status {string}")
	public void eu_valido_o_erro_retornado_com_status(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("realizo uma request PUT para {string} com novos dados {string}, {string}")
	public void realizo_uma_request_put_para_com_novos_dados(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("eu valido que os dados foram atualizados corretamente com status {string}")
	public void eu_valido_que_os_dados_foram_atualizados_corretamente_com_status(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("realizo uma request DELETE para {string}")
	public void realizo_uma_request_delete_para(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("eu valido o status de resposta {string}")
	public void eu_valido_o_status_de_resposta(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
