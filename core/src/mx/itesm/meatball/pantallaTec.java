package mx.itesm.meatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Roberto on 28/04/2016.
 */
public class pantallaTec implements Screen {

    private final Principal principal;
    private OrthographicCamera camara;
    private Viewport vista;
    //fondo
    private Texture texturaFondo;
    private Sprite spriteFondo;
    private float tiempo;
    private SpriteBatch batch;



    public pantallaTec(Principal principal) {
        this.principal=principal;
    }

    @Override
    public void show() {
        //se ejecuta uando se muestra
        camara=new OrthographicCamera(Principal.anchoMundo,Principal.altoMundo);
        camara.position.set(Principal.anchoMundo / 2, Principal.altoMundo / 2, 0);
        vista= new StretchViewport(Principal.anchoMundo,Principal.altoMundo,camara);
        batch= new SpriteBatch();

        //fondo
        cargaTexturasSprites();

    }

    private void cargaTexturasSprites() {
        texturaFondo=new Texture(Gdx.files.internal("tec1.jpg"));
        spriteFondo=new Sprite(texturaFondo);


        //spriteTexturaPlay.setPosition(Principal.anchoMundo / 2 - spriteBtnSalir.getWidth() / 2, Principal.altoMundo / 4);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Proyectar camars
        tiempo+=Gdx.graphics.getDeltaTime();
        Gdx.app.log(":v", "ataques= " + tiempo);
        batch.setProjectionMatrix(camara.combined);
        if (tiempo>=3){
            principal.setScreen(new pantallaAlbondi(principal));

        }
        //dibujamos
        batch.begin();
        spriteFondo.draw(batch);


        batch.end();

    }
    @Override
    public void resize(int width, int height) {
        vista.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        //cualdo la pantalla sale de memoria
        //Libera recursos
        texturaFondo.dispose();//regresamos la memoria


    }
}
