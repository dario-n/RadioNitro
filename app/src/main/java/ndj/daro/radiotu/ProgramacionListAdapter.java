package ndj.daro.radiotu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ProgramacionListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] itemdesc;
    private final String[] itemhora;

    private final Integer[] integers;

    public ProgramacionListAdapter(Activity context, String[] itemname,String[] itemdesc,String[] itemhora, Integer[] integers) {
        super(context, R.layout.lista_programacion, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.itemdesc = itemdesc;
        this.itemhora = itemhora;
        this.integers = integers;
    }

    public View getView(int posicion,View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.lista_programacion,null,true);

        TextView txtTitle = rowView.findViewById(R.id.programa_name);
        ImageView imageView = rowView.findViewById(R.id.programa_img);
        TextView txtDescripcion = rowView.findViewById(R.id.programa_desc);
        TextView txtHora = rowView.findViewById(R.id.programa_hora);

        txtTitle.setText(itemname[posicion]);
        imageView.setImageResource(integers[posicion]);
        txtDescripcion.setText(itemdesc[posicion]);
        txtHora.setText("Horario: "+itemhora[posicion]);

        return rowView;
    }
}
