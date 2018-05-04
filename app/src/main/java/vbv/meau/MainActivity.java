package vbv.meau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.navigation_drawer_header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.victor))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
//        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("teste");
        SecondaryDrawerItem item1 = new SecondaryDrawerItem().withIdentifier(1).withName("Meu Perfil");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Meus pets");
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Favoritos");
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4).withName("Chat");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Atalhos");
        SecondaryDrawerItem item6 = new SecondaryDrawerItem().withIdentifier(6).withName("Cadastrar um pet");
        SecondaryDrawerItem item7 = new SecondaryDrawerItem().withIdentifier(7).withName("Adotar um pet");
        SecondaryDrawerItem item8 = new SecondaryDrawerItem().withIdentifier(8).withName("Ajudar um pet");
        SecondaryDrawerItem item9 = new SecondaryDrawerItem().withIdentifier(9).withName("Apadrinhar um pet");
        PrimaryDrawerItem item10 = new PrimaryDrawerItem().withIdentifier(10).withName("Informações");
        SecondaryDrawerItem item11 = new SecondaryDrawerItem().withIdentifier(11).withName("Dicas");
        SecondaryDrawerItem item12 = new SecondaryDrawerItem().withIdentifier(12).withName("Eventos");
        SecondaryDrawerItem item13 = new SecondaryDrawerItem().withIdentifier(13).withName("Legislações");
        SecondaryDrawerItem item14 = new SecondaryDrawerItem().withIdentifier(14).withName("Termo de adoção");
        SecondaryDrawerItem item15 = new SecondaryDrawerItem().withIdentifier(15).withName("Histórias de adoção");
        PrimaryDrawerItem item16 = new PrimaryDrawerItem().withIdentifier(16).withName("Configurações");
        SecondaryDrawerItem item17 = new SecondaryDrawerItem().withIdentifier(17).withName("Privacidade");
        PrimaryDrawerItem item18 = new PrimaryDrawerItem().withIdentifier(18).withName("Sair");


        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(myToolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem(),
                        item3,
                        new DividerDrawerItem(),
                        item4,
                        new DividerDrawerItem(),
                        item5,
                        item6,
                        new DividerDrawerItem(),
                        item7,
                        new DividerDrawerItem(),
                        item8,
                        new DividerDrawerItem(),
                        item9,
                        new DividerDrawerItem(),
                        item10,
                        item11,
                        new DividerDrawerItem(),
                        item12,
                        new DividerDrawerItem(),
                        item13,
                        new DividerDrawerItem(),
                        item14,
                        new DividerDrawerItem(),
                        item15,
                        new DividerDrawerItem(),
                        item16,
                        item17,
                        new DividerDrawerItem(),
                        item18,
                        new DividerDrawerItem()

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D

                        switch (position){
                            case 0:

                        }
                        return true;
                    }
                })
                .build();
    }
}
