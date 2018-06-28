package vbv.meau;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import vbv.meau.fragments.AdoptPetFragment;
import vbv.meau.fragments.AdoptionHistoryFragment;
import vbv.meau.fragments.AdoptionTermsFragment;
import vbv.meau.fragments.ApadrinharPetFragment;
import vbv.meau.fragments.ChatFragment;
import vbv.meau.fragments.ChatListFragment;
import vbv.meau.fragments.ConfigurationsFragment;
import vbv.meau.fragments.ConfirmedPetRegistrationFragment;
import vbv.meau.fragments.EventsFragment;
import vbv.meau.fragments.FavoritesFragment;
import vbv.meau.fragments.HelpPetFragment;
import vbv.meau.fragments.IntroductionFragment;
import vbv.meau.fragments.LegislationFragment;
import vbv.meau.fragments.MyPerfilFragment;
import vbv.meau.fragments.MyPetsFragment;
import vbv.meau.fragments.PrivacyFragment;
import vbv.meau.fragments.RegisterPetFragment;
import vbv.meau.fragments.RegisterUserFragment;
import vbv.meau.fragments.TipsFragment;
import vbv.meau.models.Chat;
import vbv.meau.models.Event;
import vbv.meau.models.Pet;
import vbv.meau.models.Tip;
import vbv.meau.models.TipInfo;
import vbv.meau.models.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startFirebase();

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
        ExpandableDrawerItem item1 = new ExpandableDrawerItem().withName("Perfil").withIdentifier(999).withSelectable(false).withSelectedTextColorRes(R.color.item_name).withSelectedBackgroundAnimated(true).withSubItems(
                new SecondaryDrawerItem().withIdentifier(1).withName("Meu Perfil"),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(2).withName("Meus pets"),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(3).withName("Favoritos"),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(4).withName("Chat")
        );


        ExpandableDrawerItem item2 = new ExpandableDrawerItem().withName("Atalhos").withIdentifier(998).withSelectable(true).withSelectedTextColorRes(R.color.item_name).withDescriptionTextColorRes(R.color.item_name).withSelectedColorRes(R.color.second_menu_section_header).withSubItems(
                new SecondaryDrawerItem().withIdentifier(5).withName("Cadastrar um pet").withLevel(2),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(6).withName("Adotar um pet").withLevel(2),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(7).withName("Ajudar um pet").withLevel(2),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(8).withName("Apadrinhar um pet").withLevel(2)
        );


        ExpandableDrawerItem item3 = new ExpandableDrawerItem().withName("Informações").withIdentifier(997).withSelectable(true).withSelectedTextColorRes(R.color.item_name).withDescriptionTextColorRes(R.color.item_name).withSelectedColorRes(R.color.third_menu_section_header).withSubItems(
                new SecondaryDrawerItem().withIdentifier(9).withName("Dicas").withLevel(2),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(10).withName("Eventos").withLevel(2),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(11).withName("Legislações").withLevel(2),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(12).withName("Termo de adoção").withLevel(2),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withIdentifier(13).withName("Histórias de adoção").withLevel(2)
        );

        ExpandableDrawerItem item4 = new ExpandableDrawerItem().withName("Configurações").withIdentifier(1001).withSelectable(true).withSelectedTextColorRes(R.color.item_name).withDescriptionTextColorRes(R.color.item_name).withSelectedColorRes(R.color.fourth_menu_section_header).withSubItems(
                new SecondaryDrawerItem().withIdentifier(14).withName("Privacidade").withLevel(2)
        );

        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(15).withName("Sair");


        //create the drawer and remember the `Drawer` result object
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(myToolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        item5
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
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
                                ChatListFragment chatFragment = new ChatListFragment();
                                changeFragment(chatFragment);
                                break;
                            case 5:
                                RegisterPetFragment registerPetFragment = new RegisterPetFragment();
                                changeFragment(registerPetFragment);
                                break;
                            case 6:
                                AdoptPetFragment adoptPetFragment = new AdoptPetFragment();
                                changeFragment(adoptPetFragment);
                                break;
                            case 7:
                                HelpPetFragment helpPetFragment = new HelpPetFragment();
                                changeFragment(helpPetFragment);
                                break;
                            case 8:
                                ApadrinharPetFragment apadrinharPetFragment = new ApadrinharPetFragment();
                                changeFragment(apadrinharPetFragment);
                                break;

                            case 9:
                                TipsFragment tipsFragment = new TipsFragment();
                                changeFragment(tipsFragment);
                                break;

                            case 10:
                                EventsFragment eventsFragments = new EventsFragment();
                                changeFragment(eventsFragments);
                                break;

                            case 11:
                                LegislationFragment legislationFragment = new LegislationFragment();
                                changeFragment(legislationFragment);
                                break;

                            case 12:
                                AdoptionTermsFragment adoptionTermsFragment = new AdoptionTermsFragment();
                                changeFragment(adoptionTermsFragment);
                                break;

                            case 13:
                                AdoptionHistoryFragment adoptionHistoryFragment = new AdoptionHistoryFragment();
                                changeFragment(adoptionHistoryFragment);
                                break;

                            case 14:
                                PrivacyFragment privacyFragment = new PrivacyFragment();
                                changeFragment(privacyFragment);
                                break;

                            case 15:
                                IntroductionFragment introductionFragment = new IntroductionFragment();
                                changeFragment(introductionFragment);
                                break;
                            case 16:
                                RegisterUserFragment registerUserFragment = new RegisterUserFragment();
                                changeFragment(registerUserFragment);
                                break;

                        }
                        return false;
                    }
                })
                .withCloseOnClick(true)
                .build();


    }


    private void startFirebase(){
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference();

        Event event = new Event("Feira de adoção do guara", new Date(),"Guara 2","A feira ocorrera para arrecadar fundo para...");
        myRef.child("events").push().setValue(event);


        User user = new User("Victor Zaffalon","22","zaffalonvictor@gmail.com","DF",
                "brasilia","SQSW 202","6199923333","vzaffalon","123456","teste","teste_id");
        myRef.child("users").push().setValue(user);

        Chat chat = new Chat("Victor Zaffalon","teste chat");
        myRef.child("chats").push().setValue(chat);

        TipInfo tipInfo = new TipInfo("imagem_a","Como cuidar da unha do seu cão","para cuida da unha do seu cao...");
        ArrayList<TipInfo> tipInfos = new ArrayList<>();
        tipInfos.add(tipInfo);
        Tip tip = new Tip("Saude",tipInfos);
        myRef.child("tips").push().setValue(chat);

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
