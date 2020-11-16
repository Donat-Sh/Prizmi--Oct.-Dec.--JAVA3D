import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.universe.*; 
import com.sun.j3d.utils.geometry.*;
import java.applet.*;
import com.sun.j3d.utils.applet.MainFrame;

public class TestPrizmiDecagonal extends Applet
{ 
  public static void main(String[] args) 
   {new MainFrame(new TestPrizmiDecagonal(), 800, 600);}


  public void init() 
   { 
     GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();

     Canvas3D cv = new Canvas3D(gc);
     
     setLayout(new BorderLayout());
     add(cv, BorderLayout.CENTER);
     
     BranchGroup bg = createSceneGraph();
     bg.compile(); 
     
     SimpleUniverse su = new SimpleUniverse(cv);
     su.getViewingPlatform().setNominalViewingTransform();
     su.addBranchGraph(bg);
   } 
  
  private BranchGroup createSceneGraph() 
   {
     BranchGroup root = new BranchGroup();
     TransformGroup spin = new TransformGroup(); 

     spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); 
     root.addChild(spin);

     Appearance ap = new Appearance();
     ap.setMaterial(new Material());

     Shape3D shape = new prizmiDecagonal();
     shape.setAppearance(ap);

     Transform3D tr = new Transform3D();
     tr.setScale(0.40);

     TransformGroup tg = new TransformGroup(tr);
     spin.addChild(tg);
     tg.addChild(shape);

     Alpha alpha = new Alpha(-1, 5000);
     RotationInterpolator rotator = new RotationInterpolator(alpha, spin);

     BoundingSphere bounds = new BoundingSphere();
     rotator.setSchedulingBounds(bounds);
     spin.addChild(rotator);

     Background background = new Background(1.0f, 1.0f, 1.0f);
     background.setApplicationBounds(bounds);
     root.addChild(background); 

     AmbientLight light = new AmbientLight(true, new Color3f(Color.green));
     light.setInfluencingBounds(bounds);

     PointLight ptlight = new PointLight(new Color3f(Color.red), new Point3f(3f,3f,3f), new Point3f(1f,0f,0f));
     ptlight.setInfluencingBounds(bounds);
     root.addChild(ptlight);

     PointLight ptlight2 = new PointLight(new Color3f(Color.black), new Point3f(-2f,2f,2f), new Point3f(1f,0f,0f));
     ptlight2.setInfluencingBounds(bounds);
     root.addChild(ptlight2);
     
     return root;
  }
} 