package mx.itesm.meatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Roberto on 02/05/2016.
 */
public class pantallaHist2 implements Screen {
    private final Principal principal;
    private OrthographicCamera camara;
    private Viewport vista;
    //fondo
    private Texture texturaFondo;
    private Sprite spriteFondo;
    private SpriteBatch batch;
    private Texture texturaBtnSalir;
    private Sprite spriteBtnSalir;
    private Texture texturaBtnNext;
    private Sprite spriteBtnNext;
    public pantallaHist2(Principal principal) {
        this.principal=principal;
    }
    private void cargaTexturasSprites() {

        texturaFondo=new Texture(Gdx.files.internal("perdioP.png"));
        spriteFondo=new Sprite(texturaFondo);

        texturaBtnNext=new Texture(Gdx.files.internal("botonsiguiente.png"));
        spriteBtnNext=new Sprite(texturaBtnNext);
        spriteBtnNext.setPosition(1000, 0);
        //spriteBtnNext.setSize(100, 50);

    }

    @Override
    public void show() {
        camara=new OrthographicCamera(Principal.anchoMundo,Principal.altoMundo);
        camara.position.set(Principal.anchoMundo/2,Principal.altoMundo/2,0);
        vista= new StretchViewport(Principal.anchoMundo,Principal.altoMundo,camara);
        batch= new SpriteBatch();
        cargaTexturasSprites();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Proyectar camars
        leerEntrada();
        batch.setProjectionMatrix(camara.combined);
        //dibujamos
        batch.begin();
        spriteFondo.draw(batch);


        spriteBtnNext.draw(batch);
        batch.end();
    }

    private void leerEntrada() {
        if (Gdx.input.justTouched()==true){
            Vector3 coordenadas=new Vector3();
            coordenadas.set(Gdx.input.getX(),Gdx.input.getY(),0);
            camara.unproject(coordenadas);//transforma coordenada
            float touchX=coordenadas.x;
            float touchY=coordenadas.y;

            if (touchX>=spriteBtnNext.getX() && touchX<=spriteBtnNext.getX()+spriteBtnNext.getWidth() && touchY>=spriteBtnNext.getY() && touchY<=spriteBtnNext.getY()+spriteBtnNext.getHeight()){
                principal.setScreen(new pantallaMenu(principal));


            }

        }
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
        dispose();

    }

    @Override
    public void dispose() {
        texturaFondo.dispose();
    }
}
