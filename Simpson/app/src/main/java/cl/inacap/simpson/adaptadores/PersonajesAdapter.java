package cl.inacap.simpson.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.simpson.R;
import cl.inacap.simpson.dto.Personaje;

public class PersonajesAdapter extends ArrayAdapter<Personaje> {

    private List<Personaje> personajes;

    private Activity activity;

    public PersonajesAdapter(@NonNull Activity context, int resource, @NonNull List<Personaje> objects) {
        super(context, resource, objects);

        this.personajes=objects;

        this.activity=context;

    }

    @NonNull

    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.activity.getLayoutInflater();

        View fila=inflater.inflate(R.layout.list_personajes,null,true);

        TextView nombrePersonaje=fila.findViewById(R.id.nombrePersonaje);

        TextView frasePersonaje=fila.findViewById(R.id.frasePersonaje);

        ImageView imagenPersonaje=fila.findViewById(R.id.imagenPersonaje);

        nombrePersonaje.setText(personajes.get(position).getpersonaje());

        frasePersonaje.setText(personajes.get(position).getfrase());

        Picasso.get().load(this.personajes.get(position).getImagen()).resize(350,550).centerCrop().into(imagenPersonaje);

        return fila;

    }

}

