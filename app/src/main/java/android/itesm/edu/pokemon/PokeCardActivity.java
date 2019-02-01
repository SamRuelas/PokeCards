package android.itesm.edu.pokemon;

import android.itesm.edu.pokemon.model.PokeCard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PokeCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_card);
        //Esto para que lo que hice en pokemon recycler para que cargue la carta funcione
        PokeCard pokeCard = (PokeCard) getIntent().getSerializableExtra("pokemon");
        loadPokemon(pokeCard);
    }
    //Para que la carta se vea en la pantalla nueva
    private void loadPokemon(PokeCard pokeCard){
        TextView id, name, artist;
        ImageView image;
        id = findViewById(R.id.id_card);
        name = findViewById(R.id.card_name);
        artist = findViewById(R.id.author_card);
        image = findViewById(R.id.card);
        //Como se va a cargar la imagen de internet
        RequestOptions options = new RequestOptions().centerCrop()
                .placeholder(R.drawable.load_card).error(R.drawable.load_card);
        name.setText(pokeCard.getName());
        id.setText(pokeCard.getId());
        artist.setText(pokeCard.getArtist());

        Glide.with(this).load(pokeCard.getImageUrl()).apply(options).into(image);

    }
}
