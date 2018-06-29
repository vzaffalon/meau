package vbv.meau.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vbv.meau.R;
import vbv.meau.models.Pet;

/**
 * Created by vzaffalon on 31/05/2018.
 */

public class AdoptPetInfoFragment extends Fragment{
    private TextView nome;
    private TextView sexo;
    private TextView porte;
    private TextView idade;
    private TextView localizacao;
    private TextView saude;
    private TextView doencas;
    private TextView temperamento;
    private TextView exigencias_do_doador;
    private TextView sobre_o_animal;
    private ImageView fotos;
    private TextView necessidades_animal;
    private TextView tipo_de_cadastro; //auxilio,ajuda, apadrinhamento
    private boolean favorito;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopt_pet_info_fragment, container, false);

        Bundle bundle = getArguments();
        Pet pet= (Pet) bundle.getSerializable("pet");

        nome = (TextView) view.findViewById(R.id.nome);
        sexo = (TextView) view.findViewById(R.id.sexo);
        porte = (TextView) view.findViewById(R.id.porte);
        idade = (TextView) view.findViewById(R.id.idade);
        localizacao = (TextView) view.findViewById(R.id.localizacao);
        doencas = (TextView) view.findViewById(R.id.doencas);
        temperamento = (TextView) view.findViewById(R.id.temperamento);
        exigencias_do_doador = (TextView) view.findViewById(R.id.exigencias);
        sobre_o_animal = (TextView) view.findViewById(R.id.sobre_o_animal);
        fotos = (ImageView) view.findViewById(R.id.foto);

        nome.setText(pet.getNome());
        sexo.setText(pet.getSexo());
        porte.setText(pet.getPorte());
        idade.setText(pet.getIdade());
        localizacao.setText(pet.getLocalizacao());
        doencas.setText(pet.getDoencas());
        temperamento.setText(pet.getTemperamento());
        exigencias_do_doador.setText(pet.getExigencias_do_doador());
        sobre_o_animal.setText(pet.getSobre_o_animal());
        Picasso.get().load(pet.getFotos()).into(fotos);

        return view;
    }
}
