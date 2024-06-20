package org.controller.Pet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.Utils.ControllerUtil;
import org.model.Pet;
import org.model.Porte;
import org.model.Raca;

import java.io.IOException;
import java.util.Objects;

public class VisualizarPetController extends Application{
    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnIniciaEdicao;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltar;

    @FXML
    private ChoiceBox<String> choiceSexo;

    @FXML
    private ListView<String> listResponsaveis;

    @FXML
    private TextField txtfDono;

    @FXML
    private TextField txtfIdade;

    @FXML
    private TextField txtfNome;

    private final ControllerUtil controllerUtil = new ControllerUtil();
    private Pet pet = new Pet("Placeholder", 1, Raca.GOLDEN_RETRIEVER, Porte.GRANDE);
//    private Pet pet;

    @Override
    public void start(Stage stage) throws Exception {
        final Pane graph = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("visualizar_pet.fxml")));
        final Scene scene = new Scene(graph, 800, 600);
        stage.setTitle("Visualizar Pet");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        System.out.println(pet.getNome());
        choiceSexo.getItems().addAll("Masculino", "Feminino");
        setDefaultValues();
        txtfNome.setEditable(true);
    }

    @FXML
    void addResponsavel(ActionEvent event) {

    }

    @FXML
    void backwards(ActionEvent event) {

    }

    @FXML
    void edit(ActionEvent event) {

    }

    @FXML
    void handleEditionButton(ActionEvent event) {

    }

    @FXML
    void removeResponsavel(ActionEvent event) {
        String guardian = listResponsaveis.getSelectionModel().getSelectedItem();
        pet.removeResponsavel(guardian);
        listResponsaveis.getItems().remove(guardian);
    }

    public void setPet(Pet pet) {
        this.pet = pet;
        setDefaultValues();
    }

    private void setDefaultValues(){
        txtfNome.setText(pet.getNome());
        txtfIdade.setText(String.valueOf(pet.getIdade()));
        listResponsaveis.getItems().addAll(pet.getResponsaveis());
    }

    public void buildScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("visualizar_pet.fxml"));
        controllerUtil.changeScene(loader, event, "Detalhes Pet");
    }
}
