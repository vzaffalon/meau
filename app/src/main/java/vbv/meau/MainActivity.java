package vbv.meau;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

import vbv.meau.fragments.AdoptPetFragment;
import vbv.meau.fragments.AdoptionHistoryFragment;
import vbv.meau.fragments.AdoptionTermsFragment;
import vbv.meau.fragments.ApadrinharPetFragment;
import vbv.meau.fragments.ChatFragment;
import vbv.meau.fragments.ConfigurationsFragment;
import vbv.meau.fragments.EventsFragment;
import vbv.meau.fragments.FavoritesFragment;
import vbv.meau.fragments.HelpPetFragment;
import vbv.meau.fragments.IntroductionFragment;
import vbv.meau.fragments.LegislationFragment;
import vbv.meau.fragments.MyPerfilFragment;
import vbv.meau.fragments.MyPetsFragment;
import vbv.meau.fragments.PrivacyFragment;
import vbv.meau.fragments.RegisterPetFragment;
import vbv.meau.fragments.TipsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFirstFragment();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.navigation_drawer_header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Victor").withEmail("zaffalonvictor@gmail.com").withIcon(getResources().getDrawable(R.drawable.victor))
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
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(myToolbar)
                .withCloseOnClick(true)
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

                        switch ((int) drawerItem.getIdentifier()){
                            case 1:
                                MyPerfilFragment myPerfilFragment = new MyPerfilFragment();
                                changeFragment(myPerfilFragment);
                                break;
                            case 2:
                                MyPetsFragment myPetsFragment = new MyPetsFragment();
                                changeFragment(myPetsFragment);
                                break;
                            case 3:
                                FavoritesFragment favoritesFragment = new FavoritesFragment();
                                changeFragment(favoritesFragment);
                                break;
                            case 4:
                                ChatFragment chatFragment = new ChatFragment();
                                changeFragment(chatFragment);
                                break;
                            case 6:
                                RegisterPetFragment registerPetFragment = new RegisterPetFragment();
                                changeFragment(registerPetFragment);
                                break;
                            case 7:
                                AdoptPetFragment adoptPetFragment = new AdoptPetFragment();
                                changeFragment(adoptPetFragment);
                                break;
                            case 8:
                                HelpPetFragment helpPetFragment = new HelpPetFragment();
                                changeFragment(helpPetFragment);
                                break;
                            case 9:
                                ApadrinharPetFragment apadrinharPetFragment = new ApadrinharPetFragment();
                                changeFragment(apadrinharPetFragment);
                                break;

                            case 11:
                                TipsFragment tipsFragment = new TipsFragment();
                                changeFragment(tipsFragment);
                                break;

                            case 12:
                                EventsFragment eventsFragments = new EventsFragment();
                                changeFragment(eventsFragments);
                                break;

                            case 13:
                                LegislationFragment legislationFragment = new LegislationFragment();
                                changeFragment(legislationFragment);
                                break;

                            case 14:
                                AdoptionTermsFragment adoptionTermsFragment = new AdoptionTermsFragment();
                                changeFragment(adoptionTermsFragment);
                                break;

                            case 15:
                                AdoptionHistoryFragment adoptionHistoryFragment = new AdoptionHistoryFragment();
                                changeFragment(adoptionHistoryFragment);
                                break;

                            case 16:
                                ConfigurationsFragment configurationsFragment = new ConfigurationsFragment();
                                changeFragment(configurationsFragment);
                                break;

                            case 17:
                                PrivacyFragment privacyFragment = new PrivacyFragment();
                                changeFragment(privacyFragment);
                                break;

                            case 18:
                                //quit
                                break;

                        }
                        return true;
                    }
                })
                .build();


    }

    private void createFirstFragment(){
        // Create a new Fragment to be placed in the activity layout
        IntroductionFragment firstFragment = new IntroductionFragment();
        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();
    }


    private void changeFragment(Fragment fragment){
        // Create fragment and give it an argument specifying the article it should show
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
