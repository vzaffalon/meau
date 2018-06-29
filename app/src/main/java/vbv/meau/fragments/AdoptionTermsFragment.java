package vbv.meau.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import vbv.meau.R;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class AdoptionTermsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adoption_term_fragment, container, false);


        Button button = (Button) view.findViewById(R.id.button_adocao);
        Button button2 = (Button) view.findViewById(R.id.apadrinhamento);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"zaffalonvictor@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Termo de apadrinhamento");
                i.putExtra(Intent.EXTRA_TEXT   , "O termo de adoção é um termo que oficializa o processo de adoção de um animal. Similarmente funciona o termo de apadrinhamento.\n" +
                        "É importante que o doador/dono exija a assinatura deste termo por parte do adotante/padrinho, de forma a ter prova legal de que a pessoa adquiriu o animal. Assim, podem ser tomadas providências legais em caso de maus tratos ou negligência ao animal.\n" +
                        "Para facilitar o processo, o Meau disponibiliza o termo aos seus doadores e donos de animais que utilizam o aplicativo para encontrar um destino e/ou ajuda para seu bichinho. Este termo é enviado por e-mail para que possa ser feita a impressão e, no momento de entrega do animal (ou quando o padrinho vai conhecê-lo), seja feita a assinatura por parte do adotante/padrinho.\n" +
                        "Pressionando os botões abaixo, você receberá em seu email o termo em questão, nos formatos .doc (word) e .pdf.\n");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {

                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"zaffalonvictor@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Termo de apadrinhamento");
                i.putExtra(Intent.EXTRA_TEXT   , "O termo de adoção é um termo que oficializa o processo de adoção de um animal. Similarmente funciona o termo de apadrinhamento.\n" +
                        "É importante que o doador/dono exija a assinatura deste termo por parte do adotante/padrinho, de forma a ter prova legal de que a pessoa adquiriu o animal. Assim, podem ser tomadas providências legais em caso de maus tratos ou negligência ao animal.\n" +
                        "Para facilitar o processo, o Meau disponibiliza o termo aos seus doadores e donos de animais que utilizam o aplicativo para encontrar um destino e/ou ajuda para seu bichinho. Este termo é enviado por e-mail para que possa ser feita a impressão e, no momento de entrega do animal (ou quando o padrinho vai conhecê-lo), seja feita a assinatura por parte do adotante/padrinho.\n" +
                        "Pressionando os botões abaixo, você receberá em seu email o termo em questão, nos formatos .doc (word) e .pdf.\n");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {

                }
            }
        });
        return view;
    }
}
