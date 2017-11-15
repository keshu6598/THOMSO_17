package com.project.nikhil.thomso17;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;
import io.codetail.widget.RevealFrameLayout;
import io.codetail.widget.RevealLinearLayout;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity{
    private static final Integer[] rajasthan=
            {};

    String events="[\n    {\n    \t \"id\": 1,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Opening Ceremony\",\n    \t\"venue\": \"Convocation Hall\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"11:30\",\n    \t\"lat\": \"29.8648599\",\n    \t\"lng\": \"77.89657869999996\",\n\t\t\"coord\": \"Arihant\",\n\t\t\"coord_no\": \"8839262539\",\n\t\t\"description\": \"Inauguration Ceremony of Thomso'17- A Magic Fantasia\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 2,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Vogue Prelims\",\n    \t\"venue\": \"MAC Audi\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"13:00\",\n    \t\"lat\": \"29.87008245649282\",\n    \t\"lng\": \"77.89633333683014\",\n\t\t\"coord\": \"Himanshu Goyal\",\n\t\t\"coord_no\": \"7060863011\",\n\t\t\"description\": \"Do you love owning the world with your elegance and glamour? So why fit in when you were born to stand out? With the adage \u0093Classy and Fabulous\u0094 on back of our minds, we have this event planned out to cater to the fashionista in all of us. A breath stopper at Thomso where sculpted males and gorgeous females sizzle the ramp with their display of sensational apparels, radiating confidence and mystique. We invite you to break out of the mould and scintillate the world with your glamour and confidence, on a stage graced with the likes of Sushmita Sen, Annie Thomas, Udita Goswami and other bigwigs in the past.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"vogue\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 3,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Venture Unplugged 2.0\",\n    \t\"venue\": \"Mac Audi\",\n    \t\"start_time\": \"15:00\",\n    \t\"end_time\": \"18:00\",\n    \t\"lat\": \"29.87008245649282,\",\n    \t\"lng\": \"77.89633333683014\",\n\t\t\"coord\": \"Ayush Gupta\",\n\t\t\"coord_no\": \"8872205522\",\n\t\t\"description\": \"\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 4,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Footloose Prelims\",\n    \t\"venue\": \"Convocation Hall\",\n    \t\"start_time\": \"12:30\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.8648599\",\n    \t\"lng\": \"77.89657869999996\",\n\t\t\"coord\": \"Aditi Bhatt\",\n\t\t\"coord_no\": \"7060334165\",\n\t\t\"description\": \"Are you passionate about dancing? Do you have tingling sensations run down your feet when you hear music? Then complete yourself loose. Dance to express. Its said that in order to find your true self, you first have to lose yourself. Come get lost amid the likes of yourself.Prepare, perfect, perform and if you stumble then make it a part of the dance.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"footloose\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 6,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Apocalypse\",\n    \t\"venue\": \"MAC Hall\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.870201077123927\",\n    \t\"lng\": \"77.89620995521545\",\n\t\t\"coord\": \"Suchit\",\n\t\t\"coord_no\": \"8818986897\",\n\t\t\"description\": \"Beating a game is a journey. Therein lies the fun.Are you one of those who think gaming is their DNA? Do you get an adrenaline rush every time you conquer a game? Welcome to Apocalypse, a cut throat competition with intense competition and massive crowds,this is one gaming competition you wouldn\u0092t want to miss. So gear up and let your game speak for you. Strike new camaraderie and build up envious rivalries in this hard fought event, where shots are traded across battle lines. Show us your hard acquired gaming skills and aim to vanquish all.So if you think you are the one to obliterate the competition, then Apocalypse is the place to be!Level up, fall down, respawn and get back up to earn the coveted crown.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"apocalypse\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 7,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Sargam Prelims\",\n    \t\"venue\": \"OAT MAC\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.870330164121057\",\n    \t\"lng\": \"77.89624013006687\",\n\t\t\"coord\": \"Kartik\",\n\t\t\"coord_no\": \"9557940827\",\n\t\t\"description\": \"In the words of Plato: Music gives a soul to the universe, wings to the mind, flight to the imagination and life to everything.This is your chance to flaunt your gift. Here\u0092s an opportunity to get on stage and tell your story through your flair. It\u0092s the IITR\u0092s premier singing contest. If you believe in yourself then come compete with the elite.You can sing or play an instrument. Just be your best self and own the stage. !\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"sargam\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 8,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Mary Jane Green Field(MJGF)\",\n    \t\"venue\": \"OAT (Swimming Pool)\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8670887\",\n    \t\"lng\": \"77.89750570000001\",\n\t\t\"coord\": \"Sanjil Jain\",\n\t\t\"coord_no\": \"7248486009\",\n\t\t\"description\": \"We believe there is an untold story behind every form of music. Here\u0092s a chance to tell your story hidden behind the inscrutable chords and melodies. Mary Jane Green Fields is an exciting opportunity for emerging English bands to prove their prowess behind blaring drums and guitars. With lucrative prizes and a shot at nationwide fame, this is not an opportunity to be missed out on!\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"mary_jane_green_field\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 9,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Snooker's Elite\",\n    \t\"venue\": \"Student's Club\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"18:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Surya\",\n\t\t\"coord_no\": \"8171781255\",\n\t\t\"description\": \"Do you think what it take to be the master of cues? If yes, come forth and compete with your contemporaries and prove your mettle; because if you can\u0092t prove, you don\u0092t have. This event gives you an opportunity to compete with the elites and let the world witness your flair. The table is set, now is the time for you to hit.The event consist of the following two of the table games: Snooker & Pool, which are by far, the benchmarks of precision and skill.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"snooker_elite\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 10,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Corporata\",\n    \t\"venue\": \"DOMS\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.8646738\",\n    \t\"lng\": \"77.89483530000007\",\n\t\t\"coord\": \"Nishant\",\n\t\t\"coord_no\": \"8298508272\",\n\t\t\"description\": \"How much do you know when it comes to finance and economics?Here\u0092s a chance to build upon that financial repertoire of yours and sharpen your business acumen.Corporata provides you a platform to boast about your financial literacy and general economic awareness. Test your understanding of core financial knowledge against the best in the game and astound the jury with your business insights.With fierce competition and loads of rewards to be won, this sure is going to be a nerve-wracking contest.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"corporata\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 11,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Soci O Fun\",\n    \t\"venue\": \"LHC 103\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"16:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Ritika\",\n\t\t\"coord_no\": \"9627936406\",\n\t\t\"description\": \"Social Ideas Feasible for United Nations\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"soci_o_fun\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 13,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Campus Diva Prelims\",\n    \t\"venue\": \"LHC 003\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"14:00\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Aparna\",\n\t\t\"coord_no\": \"9497443365\",\n\t\t\"description\": \"Girls this one is for you all. Have you ever speculated how sumptuos and grogeous you would look when you dress up like Cindrella or Snow White or any other disney Princess ? When Thousands of people are gazing at you and you mesmerise them with your beauty leaving them awestruck. When you realise that your childhood dream has come true and you are living it..... Ever wanted to feel the beauty within you and show the world the real you, Thomso 2k17, with the theme of A Magical Fantasia is giving you all the opportunity to become Amparo Munoz or Janelle Commissiong of this Song of the Wildflower which will be Beating at this years Thomso.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"campus_princess\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 14,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Quriosity MELA Quiz\",\n    \t\"venue\": \"LHC 003\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"17:00\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Nikhil\",\n\t\t\"coord_no\": \"8006487820\",\n\t\t\"description\": \"Do you know everything from the funfacts about infinity war to the intracacies of global economics? Are you generally shunned among peers for being a know-it-all?( OR: does information unintentionally comes blurting out whenever you open your mouth?) Well here you can actually win prizes for that! So come and embrace the chance to show the ignoramuses that information is the real wealth! Five quizzing events shall be held. 1. Titans of Trivia\u0096 The general quiz. 2. The MELA \u0096 Music, Entertainment, Literature and Art 3. The India Quiz 4. The Sports Quiz 5. The Business Quiz\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"quriosity\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 15,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Quriosity Business Quiz\",\n    \t\"venue\": \"LHC 003\",\n    \t\"start_time\": \"17:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Nikhil\",\n\t\t\"coord_no\": \"8006487820\",\n\t\t\"description\": \"Do you know everything from the funfacts about infinity war to the intracacies of global economics? Are you generally shunned among peers for being a know-it-all?( OR: does information unintentionally comes blurting out whenever you open your mouth?) Well here you can actually win prizes for that! So come and embrace the chance to show the ignoramuses that information is the real wealth! Five quizzing events shall be held. 1. Titans of Trivia\u0096 The general quiz. 2. The MELA \u0096 Music, Entertainment, Literature and Art 3. The India Quiz 4. The Sports Quiz 5. The Business Quiz\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"quriosity\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 17,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Mr. & Ms. Thomso Prelims\",\n    \t\"venue\": \"LHC 006\",\n    \t\"start_time\": \"12:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Krishnendu\",\n\t\t\"coord_no\": \"7253046172\",\n\t\t\"description\": \"'One of the biggest regrets in life is projecting yourself as what people want you to be, rather than being yourself.' \u0096 Shannon L. Adler So do you think yourself as the right blend of beauty, attitude and wit? Do you have what it takes to win the prestigious crown? We offer you a chance to break out of conformity and get a shot at glory. Mr. and Ms. Thomso is an illustrious event probing the charismatic as well as intellectual side of the participants.Embrace your uniqueness in this stellar event of individuality and temperament. Come and experience the joy of new encounters and an endlessly changing horizon.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"mr_and_ms_thomso\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 18,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Seiger Prelims\",\n    \t\"venue\": \"LHC 102\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Sagar\",\n\t\t\"coord_no\": \"9479588083\",\n\t\t\"description\": \"Seiger is IIT Roorkee\u0092s own rendition of the very (in)famous TV show, Roadies! Come and try your best not to embarrass yourself as our own Raghu goes full-throttle on you!\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"seiger\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 20,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Nukkad Natak Prelims\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"15:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Shivam\",\n\t\t\"coord_no\": \"9012400090\",\n\t\t\"description\": \"Nukkad Natak is a street-play competition of Dramatics at Thomso where you speak in the lingo of the common folks to outline captivating issues which are also socially relevant. The main endeavor is to convey a social and political message in an entertaining environment, amidst the intimate and effective means of theatre by means of shout, chants, drums and catchy songs.This is your chance to be the change you think of bringing about.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"nukkad_natak\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n    {\n    \t \"id\": 21,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Step-Up Prelims\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"15:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Riya\",\n\t\t\"coord_no\": \"9759734528\",\n\t\t\"description\": \"Have you ever had the desire to express the hidden language of your soul, make the music visible and simply be insane? We'll provide you the level field to be fearless, limitless and well, as we promised before, insane. There are no spring floors, no spotlights, no stage, and no boundaries. Come on the streets to glide, to spin, to fly or to expression to all your instincts, bring your style on the floor. Dance on the random music being played and show your instincts to dance. Step-Up is an on-the- spot street dance competition.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"step_up\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n    {\n    \t \"id\": 23,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Treasure Hunt\",\n    \t\"venue\": \"Library Steps\",\n    \t\"start_time\": \"11:30\",\n    \t\"end_time\": \"14:00\",\n    \t\"lat\": \"29.8652785\",\n    \t\"lng\": \"77.89478239999994\",\n\t\t\"coord\": \"Shwetank\",\n\t\t\"coord_no\": \"9711008976\",\n\t\t\"description\": \"This time it\u0092s not about you, it\u0092s not even about your team, it\u0092s about what defines you and your team.It\u0092s not for the faint hearted but only for the fierce ones who can make their way through anything.Starting with the dose of awesomeness the Mafioso&#39;s will have to rise through the war of grilling rounds.If you think that your team have, what it takes to be triumphed, then get your guns ready for the sheer breath-taking thrill of the treasure hunt. For where your treasure is, there will your heart be also.The Campus Treasure Hunt is waiting for you. May the odds be ever in your favour!\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"treasure_hunt\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\t\n\t},\n    {\n    \t \"id\": 24,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Campus Diva Stage Rehersals\",\n    \t\"venue\": \"Convocation Hall\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"09:30\",\n    \t\"lat\": \"29.8648599\",\n    \t\"lng\": \"77.89657869999996\",\n\t\t\"coord\": \"Aparna\",\n\t\t\"coord_no\": \"9497443365\",\n\t\t\"description\": \"Girls this one is for you all. Have you ever speculated how sumptuos and grogeous you would look when you dress up like Cindrella or Snow White or any other disney Princess ? When Thousands of people are gazing at you and you mesmerise them with your beauty leaving them awestruck. When you realise that your childhood dream has come true and you are living it..... Ever wanted to feel the beauty within you and show the world the real you, Thomso 2k17, with the theme of A Magical Fantasia is giving you all the opportunity to become Amparo Munoz or Janelle Commissiong of this Song of the Wildflower which will be Beating at this years Thomso.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"campus_princess\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n    {\n    \t \"id\": 25,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Footloose Prelims\",\n    \t\"venue\": \"Convocation Hall\",\n    \t\"start_time\": \"09:30\",\n    \t\"end_time\": \"16:00\",\n    \t\"lat\": \"29.8648599\",\n    \t\"lng\": \"77.89657869999996\",\n\t\t\"coord\": \"Aditi Bhatt\",\n\t\t\"coord_no\": \"7060334165\",\n\t\t\"description\": \"Are you passionate about dancing? Do you have tingling sensations run down your feet when you hear music? Then complete yourself loose. Dance to express. Its said that in order to find your true self, you first have to lose yourself. Come get lost amid the likes of yourself.Prepare, perfect, perform and if you stumble then make it a part of the dance.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"footloose\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n    {\n    \t \"id\": 26,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Campus Diva Final\",\n    \t\"venue\": \"Convocation Hall\",\n    \t\"start_time\": \"16:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.8648599\",\n    \t\"lng\": \"77.89657869999996\",\n\t\t\"coord\": \"Aparna\",\n\t\t\"coord_no\": \"9497443365\",\n\t\t\"description\": \"Girls this one is for you all. Have you ever speculated how sumptuos and grogeous you would look when you dress up like Cindrella or Snow White or any other disney Princess ? When Thousands of people are gazing at you and you mesmerise them with your beauty leaving them awestruck. When you realise that your childhood dream has come true and you are living it..... Ever wanted to feel the beauty within you and show the world the real you, Thomso 2k17, with the theme of A Magical Fantasia is giving you all the opportunity to become Amparo Munoz or Janelle Commissiong of this Song of the Wildflower which will be Beating at this years Thomso.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"campus_princess\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n    {\n    \t \"id\": 27,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Seiger Finals\",\n    \t\"venue\": \"SBI Lawn\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"16:00\",\n    \t\"lat\": \"29.8645778\",\n    \t\"lng\": \"77.89564769999993\",\n\t\t\"coord\": \"Sagar\",\n\t\t\"coord_no\": \"9479588083\",\n\t\t\"description\": \"Seiger is IIT Roorkee\u0092s own rendition of the very (in)famous TV show, Roadies! Come and try your best not to embarrass yourself as our own Raghu goes full-throttle on you!\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"seiger\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n    {\n    \t \"id\": 28,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Mr. & Ms. Thomso\",\n    \t\"venue\": \"MAC Audi\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"13:00\",\n    \t\"lat\": \"29.87008245649282\",\n    \t\"lng\": \"77.89633333683014\",\n\t\t\"coord\": \"Krishnendu\",\n\t\t\"coord_no\": \"7253046172\",\n\t\t\"description\": \"'One of the biggest regrets in life is projecting yourself as what people want you to be, rather than being yourself.' \u0096 Shannon L. Adler So do you think yourself as the right blend of beauty, attitude and wit? Do you have what it takes to win the prestigious crown? We offer you a chance to break out of conformity and get a shot at glory. Mr. and Ms. Thomso is an illustrious event probing the charismatic as well as intellectual side of the participants.Embrace your uniqueness in this stellar event of individuality and temperament. Come and experience the joy of new encounters and an endlessly changing horizon.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"mr_and_ms_thomso\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n    {\n    \t \"id\": 29,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Sargam Finals\",\n    \t\"venue\": \"MAC Audi\",\n    \t\"start_time\": \"13:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.87008245649282\",\n    \t\"lng\": \"77.89633333683014\",\n\t\t\"coord\": \"Kartik\",\n\t\t\"coord_no\": \"9557940827\",\n\t\t\"description\": \"In the words of Plato: Music gives a soul to the universe, wings to the mind, flight to the imagination and life to everything.This is your chance to flaunt your gift. Here\u0092s an opportunity to get on stage and tell your story through your flair. It\u0092s the IITR\u0092s premier singing contest. If you believe in yourself then come compete with the elite.You can sing or play an instrument. Just be your best self and own the stage. !\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"sargam\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n    {\n    \t \"id\": 30,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Apocalypse\",\n    \t\"venue\": \"MAC Hall\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.870201077123927\",\n    \t\"lng\": \"77.89620995521545\",\n\t\t\"coord\": \"Suchit\",\n\t\t\"coord_no\": \"8818986897\",\n\t\t\"description\": \"Beating a game is a journey. Therein lies the fun.Are you one of those who think gaming is their DNA? Do you get an adrenaline rush every time you conquer a game? Welcome to Apocalypse, a cut throat competition with intense competition and massive crowds,this is one gaming competition you wouldn\u0092t want to miss. So gear up and let your game speak for you. Strike new camaraderie and build up envious rivalries in this hard fought event, where shots are traded across battle lines. Show us your hard acquired gaming skills and aim to vanquish all.So if you think you are the one to obliterate the competition, then Apocalypse is the place to be!Level up, fall down, respawn and get back up to earn the coveted crown.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"apocalypse\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n    {\n    \t \"id\": 32,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Abhivyakti Prelims\",\n    \t\"venue\": \"OP Jain Audi\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8630789\",\n    \t\"lng\": \"77.89883320000001\",\n\t\t\"coord\": \"Aashutosh\",\n\t\t\"coord_no\": \"9084768046\",\n\t\t\"description\": \"All the world's a stage, and all the men and women merely players. This event is for those who act, write, dance, run, cry and laugh just for the ethereal beauty of the act. Stand on a stage and hold the hearts of men in your hands. Make them laugh with a gesture and cry with words. Turn the spotlight towards you, perfecting acting skills, coordination, expressions and stellar dialogue delivery.We have this event planned out to cater to all those patrons of direction, acting and screenplay. So participate and hypnotize people with the power of words and expressions and you will shine brighter than any praise or fame or glory\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"abhivyakti\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 33,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Costume Design\",\n    \t\"venue\": \"OAT MAC\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.870330164121057\",\n    \t\"lng\": \"77.89624013006687\",\n\t\t\"coord\": \"Neeraj\",\n\t\t\"coord_no\": \"8979991069\",\n\t\t\"description\": \"A great dress can make you remember what is beautiful about life. This Thomso let your creativity go bersek and gear up to dress up your friend in the most innovative fashion.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"costume_design\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 34,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Battle Of Bands\",\n    \t\"venue\": \"OAT Swimming Pool\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.8670887\",\n    \t\"lng\": \"77.89750570000001\",\n\t\t\"coord\": \"Chaitanya Gupta\",\n\t\t\"coord_no\": \"9557980313\",\n\t\t\"description\": \"Do you think your voice matters? Do you have the power to change the mood or move the world with a single tone? If you think you can make the crowd forget themselves in your performance, then this is the place to be. Thomso welcomes you to B.O.B (Battle of Bands), an arena to battle against India\u0092s best Hindi bands. With massive enthusiasm and fearsome competition, this event brings out the best in its participants striving for glory. If you have the band that just can\u0092t lose and have hunger for more, then come and perform against the most formidable bands in India.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"battle_of_bands\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t {\n    \t \"id\": 35,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Snooker Elite\",\n    \t\"venue\": \"Student's Club\",\n    \t\"start_time\": \"10:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Surya\",\n\t\t\"coord_no\": \"8171781255\",\n\t\t\"description\": \"Do you think what it take to be the master of cues? If yes, come forth and compete with your contemporaries and prove your mettle; because if you can\u0092t prove, you don\u0092t have. This event gives you an opportunity to compete with the elites and let the world witness your flair. The table is set, now is the time for you to hit.The event consist of the following two of the table games: Snooker & Pool, which are by far, the benchmarks of precision and skill.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"snooker_elite\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 36,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Mark Sense\",\n    \t\"venue\": \"DOMS\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"15:30\",\n    \t\"lat\": \"29.8646738\",\n    \t\"lng\": \"77.89483530000007\",\n\t\t\"coord\": \"Aakash Bharti\",\n\t\t\"coord_no\": \"9928249005\",\n\t\t\"description\": \"Introduction Mark - Sense: Marketing Event For Poster Quotes that can be used: Marketing is a race without a finishing line ? Philip Kotler.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"mark_sense\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 37,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Corporata\",\n    \t\"venue\": \"DOMS\",\n    \t\"start_time\": \"15:30\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8646738\",\n    \t\"lng\": \"77.89483530000007\",\n\t\t\"coord\": \"Nishant\",\n\t\t\"coord_no\": \"8298508272\",\n\t\t\"description\": \"How much do you know when it comes to finance and economics?Here\u0092s a chance to build upon that financial repertoire of yours and sharpen your business acumen.Corporata provides you a platform to boast about your financial literacy and general economic awareness. Test your understanding of core financial knowledge against the best in the game and astound the jury with your business insights.With fierce competition and loads of rewards to be won, this sure is going to be a nerve-wracking contest.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"corporata\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 38,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Street Soccer\",\n    \t\"venue\": \"Basketball Court\",\n    \t\"start_time\": \"10:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.866386539114586\",\n    \t\"lng\": \"77.89640575647354\",\n\t\t\"coord\": \"Shubham\",\n\t\t\"coord_no\": \"9621849586\",\n\t\t\"description\": \"Street soccer is an informal game of soccer played in the street. A more happening and exciting version of the formal game, the main objective of both the games remains the same. The players aim to score goals by advancing the ball down the field into the opposing team's goal. And the team with the maximum goals win.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"street_soccer\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 39,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Auction Frenzy\",\n    \t\"venue\": \"LHC 004\",\n    \t\"start_time\": \"11:30\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Vishal\",\n\t\t\"coord_no\": \"8224016887\",\n\t\t\"description\": \"It\u0092s the time of the year when players go under the hammer. Welcome to Thomso\u0092s edition of IPL auction. It\u0092s time to place your bid. But beware. Don\u0092t forget to analyze and assess the situation before expending. Build your dream team. Choose among the top players from around the world. Trust your intuition and spend wisely in the high paced bidding frenzy.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"auction_frenzy\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 40,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Auction Frenzy\",\n    \t\"venue\": \"LHC 004\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Vishal\",\n\t\t\"coord_no\": \"8224016887\",\n\t\t\"description\": \"It\u0092s the time of the year when players go under the hammer. Welcome to Thomso\u0092s edition of IPL auction. It\u0092s time to place your bid. But beware. Don\u0092t forget to analyze and assess the situation before expending. Build your dream team. Choose among the top players from around the world. Trust your intuition and spend wisely in the high paced bidding frenzy.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"auction_frenzy\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 42,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"TeleSporcle\",\n    \t\"venue\": \"LHC 103\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Vipul\",\n\t\t\"coord_no\": \"8160363093\",\n\t\t\"description\": \"This event will comprise of questionnaires related to 5 popular American TV Series: Suits, How I Met Your Mother, Sherlock, F.R.I.E.N.D.S. and Game of Thrones. Participants will participate in teams of two.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"tellysporcle\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 43,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"TeleSporcle\",\n    \t\"venue\": \"LHC 103\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"16:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Vipul\",\n\t\t\"coord_no\": \"8160363093\",\n\t\t\"description\": \"This event will comprise of questionnaires related to 5 popular American TV Series: Suits, How I Met Your Mother, Sherlock, F.R.I.E.N.D.S. and Game of Thrones. Participants will participate in teams of two.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"tellysporcle\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 44,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Queen's Gambit\",\n    \t\"venue\": \"LHC 003\",\n    \t\"start_time\": \"16:30\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Amit\",\n\t\t\"coord_no\": \"8126116530\",\n\t\t\"description\": \"Do you pursuegood chess skills,but do not feel like playing those 30+minute games?If yes, then this is the best platform to show off your skills.Instead of playing tediously long matches on a chess board, this is a unique Chess tactics solving competition.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"queen_gambit\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 45,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Quriosity India Quiz\",\n    \t\"venue\": \"LHC 002\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"16:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Nikhil\",\n\t\t\"coord_no\": \"8006487820\",\n\t\t\"description\": \"Do you know everything from the funfacts about infinity war to the intracacies of global economics? Are you generally shunned among peers for being a know-it-all?( OR: does information unintentionally comes blurting out whenever you open your mouth?) Well here you can actually win prizes for that! So come and embrace the chance to show the ignoramuses that information is the real wealth! Five quizzing events shall be held. 1. Titans of Trivia\u0096 The general quiz. 2. The MELA \u0096 Music, Entertainment, Literature and Art 3. The India Quiz 4. The Sports Quiz 5. The Business Quiz\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"quriosity\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 46,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Paint Fiesta\",\n    \t\"venue\": \"LHC ATR\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Aashutosh\",\n\t\t\"coord_no\": \"8969507335\",\n\t\t\"description\": \"Painting, by nature, is one luminous language; a language that never runs out of words and expression. Plutarch once said: Painting is silent poetry, and poetry is painting that speaks .This Thomso, nothing stops you as you reveal what\u0092s on your mind, your way, with all the colors you can manage!\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"paint_fiesta\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 47,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"YOUNG\",\n    \t\"venue\": \"LHC ATR\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"\",\n\t\t\"coord_no\": \"\",\n\t\t\"description\": \"Photo booths at Thomso will provide you some goofy and memorable photographic moments. So get ready to pose wackily in front of the cameras with some awesome backgrounds and silly accessories that will add up to your fun and frolic in the fest.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"young\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 49,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Nukkad Natak Finals\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"14:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Shivam Pal\",\n\t\t\"coord_no\": \"9012400090\",\n\t\t\"description\": \"Nukkad Natak is a street-play competition of Dramatics at Thomso where you speak in the lingo of the common folks to outline captivating issues which are also socially relevant. The main endeavor is to convey a social and political message in an entertaining environment, amidst the intimate and effective means of theatre by means of shout, chants, drums and catchy songs.This is your chance to be the change you think of bringing about.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"nukkad_natak\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 50,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Flash Mob\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"14:30\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Kanika\",\n\t\t\"coord_no\": \"8949670382\",\n\t\t\"description\": \"A flash mob is a group of people who assemble at a public place and perform an unusual and seemingly pointless act for a brief time for the purpose of entertainment and artistic expression and then they disperse. Its about doing something crazy and bizarre to entertain people around.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"flash_mob\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 51,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Step Up Prelims\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"14:30\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Riya\",\n\t\t\"coord_no\": \"9759734528\",\n\t\t\"description\": \"Have you ever had the desire to express the hidden language of your soul, make the music visible and simply be insane? We'll provide you the level field to be fearless, limitless and well, as we promised before, insane. There are no spring floors, no spotlights, no stage, and no boundaries. Come on the streets to glide, to spin, to fly or to expression to all your instincts, bring your style on the floor. Dance on the random music being played and show your instincts to dance. Step-Up is an on-the- spot street dance competition.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"step_up\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n    \t \"id\": 31,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Graph-O-Map Prelims\",\n    \t\"venue\": \"LHC 006\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"16:00\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Tanmay\",\n\t\t\"coord_no\": \"8016267547\",\n\t\t\"description\": \"Calling all puzzle seekers, data enthusiasts and creative minds.Thomso, IIT Roorkee, brings to you an experience, tailor-made to satiate your innate desires to be like Sherlock Holmes. A competition that combines riddles, puzzles and data interpretation skills in a fun way. If you love the thrill and satisfaction of cracking puzzles, Graph-o-map is for you.The event will be held on 2 consecutive days during Thomso'17.Prizes worth 20k to be won.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\t\n\t},\n\t{\n\t\t \"id\": 52,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Scavenger Hunt\",\n    \t\"venue\": \"Library Steps\",\n    \t\"start_time\": \"10:00\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8652785\",\n    \t\"lng\": \"77.89478239999994\",\n\t\t\"coord\": \"Aakash\",\n\t\t\"coord_no\": \"8708396002\",\n\t\t\"description\": \"A game typically played in extensive outdoor area in which participants have to collect a number of miscellaneous objects. Organisers prepare a list defining items which the participant have to seek or gather. The team which returns first with all the items becomes the winner.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"scavenger_hunt\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\n\t},\n\t{\n\t\t \"id\": 53,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Naqaab\",\n    \t\"venue\": \"SDS Lab Park\",\n    \t\"start_time\": \"10:00\",\n    \t\"end_time\": \"12:30\",\n    \t\"lat\": \"29.86349\",\n    \t\"lng\": \"77.89481899999998\",\n\t\t\"coord\": \"Hitesh\",\n\t\t\"coord_no\": \"8650267071\",\n\t\t\"description\": \"Your partner is your canvas as we take make-ups to a whole new level! Let your creativity out loose and paint your partner\u0092s face to serve as a mask, because being yourself might be cool, but it\u0092s cooler to be Batman!\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"naqaab\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\n\t},\n\t{\n\t\t \"id\": 54,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Footloose Finals\",\n    \t\"venue\": \"Convocation Hall\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"17:00\",\n    \t\"lat\": \"29.8648599\",\n    \t\"lng\": \"77.89657869999996\",\n\t\t\"coord\": \"Aditi Bhatt\",\n\t\t\"coord_no\": \"7060334165\",\n\t\t\"description\": \"Are you passionate about dancing? Do you have tingling sensations run down your feet when you hear music? Then complete yourself loose. Dance to express. Its said that in order to find your true self, you first have to lose yourself. Come get lost amid the likes of yourself.Prepare, perfect, perform and if you stumble then make it a part of the dance.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"footloose\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 55,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Seiger Finals\",\n    \t\"venue\": \"SBI Lawn\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"12:30\",\n    \t\"lat\": \"29.8645778\",\n    \t\"lng\": \"77.89564769999993\",\n\t\t\"coord\": \"Sagar\",\n\t\t\"coord_no\": \"9479588083\",\n\t\t\"description\": \"Seiger is IIT Roorkee\u0092s own rendition of the very (in)famous TV show, Roadies! Come and try your best not to embarrass yourself as our own Raghu goes full-throttle on you!\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"seiger\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 56,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Thomso's Got Talent\",\n    \t\"venue\": \"MAC Audi\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"14:00\",\n    \t\"lat\": \"29.87008245649282\",\n    \t\"lng\": \"77.89633333683014\",\n\t\t\"coord\": \"Khyati Jain\",\n\t\t\"coord_no\": \"7060334500\",\n\t\t\"description\": \"Talent is entrusted to a man as a treasure which must not be squandered. Do you have a flair towards the extraordinary? Do you have the motivation to transform your talent into genius? This Thomso, we offer you a chance to spread your wings and explore your talents in front of a captivating audience. This event has its participants showcasing their superfluity of talents, be it singing, dancing, comedy, magic or any quirky thing you are passionately curious about. So get all riled up, practice, perfect and work your way towards glory in this gem of an event.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"thomso_got_talent\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 59,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Apocalypse Finals\",\n    \t\"venue\": \"MAC Hall\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.870201077123927\",\n    \t\"lng\": \"77.89620995521545\",\n\t\t\"coord\": \"Suchit\",\n\t\t\"coord_no\": \"8818986897\",\n\t\t\"description\": \"Beating a game is a journey. Therein lies the fun.Are you one of those who think gaming is their DNA? Do you get an adrenaline rush every time you conquer a game? Welcome to Apocalypse, a cut throat competition with intense competition and massive crowds,this is one gaming competition you wouldn\u0092t want to miss. So gear up and let your game speak for you. Strike new camaraderie and build up envious rivalries in this hard fought event, where shots are traded across battle lines. Show us your hard acquired gaming skills and aim to vanquish all.So if you think you are the one to obliterate the competition, then Apocalypse is the place to be!Level up, fall down, respawn and get back up to earn the coveted crown.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"apocalypse\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 60,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Abhivyakti Finals\",\n    \t\"venue\": \"OP Jain Audi\",\n    \t\"start_time\": \"10:00\",\n    \t\"end_time\": \"14:30\",\n    \t\"lat\": \"29.8630789\",\n    \t\"lng\": \"77.89883320000001\",\n\t\t\"coord\": \"Aashutosh\",\n\t\t\"coord_no\": \"9084768046\",\n\t\t\"description\": \"All the world's a stage, and all the men and women merely players. This event is for those who act, write, dance, run, cry and laugh just for the ethereal beauty of the act. Stand on a stage and hold the hearts of men in your hands. Make them laugh with a gesture and cry with words. Turn the spotlight towards you, perfecting acting skills, coordination, expressions and stellar dialogue delivery.We have this event planned out to cater to all those patrons of direction, acting and screenplay. So participate and hypnotize people with the power of words and expressions and you will shine brighter than any praise or fame or glory\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"abhivyakti\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 61,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"16-Frames\",\n    \t\"venue\": \"OP Jain Audi\",\n    \t\"start_time\": \"14:30\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8630789\",\n    \t\"lng\": \"77.89883320000001\",\n\t\t\"coord\": \"Mayank\",\n\t\t\"coord_no\": \"9926992157\",\n\t\t\"description\": \"Oh how Shakespeare would have loved cinema! Many loves to watch it , but only few dares to create it . For those , whose interest lies in movie making this is the instant in your life when you can visualize yourself as the Maker of a Billion Dollar earning film or a socially impacting documentary.The thoughts about how movies like The French Connection and Deliverance were made may have revolved in your minds day in and out...So we at The Song of the Wildflower are giving you opportunity to exculpate the Movie Maker within you....We hope that you come along and compose your movies with the magic at Thomso...2k17..\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"16_frames\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 62,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Snooker Elite\",\n    \t\"venue\": \"Student's Club\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Surya\",\n\t\t\"coord_no\": \"8171781255\",\n\t\t\"description\": \"Do you think what it take to be the master of cues? If yes, come forth and compete with your contemporaries and prove your mettle; because if you can\u0092t prove, you don\u0092t have. This event gives you an opportunity to compete with the elites and let the world witness your flair. The table is set, now is the time for you to hit.The event consist of the following two of the table games: Snooker & Pool, which are by far, the benchmarks of precision and skill.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"snooker_elite\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 63,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Mark Sense\",\n    \t\"venue\": \"DOMS\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8646738\",\n    \t\"lng\": \"77.89483530000007\",\n\t\t\"coord\": \"Aakash\",\n\t\t\"coord_no\": \"9928249005\",\n\t\t\"description\": \"Introduction Mark - Sense: Marketing Event For Poster Quotes that can be used: Marketing is a race without a finishing line ? Philip Kotler.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"mark_sense\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 64,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Street Soccer Final\",\n    \t\"venue\": \"Basketball Court\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"14:30\",\n    \t\"lat\": \"29.866386539114586\",\n    \t\"lng\": \"77.89640575647354\",\n\t\t\"coord\": \"Shubham\",\n\t\t\"coord_no\": \"9621849586\",\n\t\t\"description\": \"Street soccer is an informal game of soccer played in the street. A more happening and exciting version of the formal game, the main objective of both the games remains the same. The players aim to score goals by advancing the ball down the field into the opposing team's goal. And the team with the maximum goals win.\",\n\t\t\"image\": \"street_soccer\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 65,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Quriosity Sports Quiz\",\n    \t\"venue\": \"LHC 004\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Nikhil\",\n\t\t\"coord_no\": \"8006487820\",\n\t\t\"description\": \"Do you know everything from the funfacts about infinity war to the intracacies of global economics? Are you generally shunned among peers for being a know-it-all?( OR: does information unintentionally comes blurting out whenever you open your mouth?) Well here you can actually win prizes for that! So come and embrace the chance to show the ignoramuses that information is the real wealth! Five quizzing events shall be held. 1. Titans of Trivia\u0096 The general quiz. 2. The MELA \u0096 Music, Entertainment, Literature and Art 3. The India Quiz 4. The Sports Quiz 5. The Business Quiz\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"quriosity\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 66,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Quriosity Titan of Trivia\",\n    \t\"venue\": \"LHC 004\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"17:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Nikhil\",\n\t\t\"coord_no\": \"8006487820\",\n\t\t\"description\": \"Do you know everything from the funfacts about infinity war to the intracacies of global economics? Are you generally shunned among peers for being a know-it-all?( OR: does information unintentionally comes blurting out whenever you open your mouth?) Well here you can actually win prizes for that! So come and embrace the chance to show the ignoramuses that information is the real wealth! Five quizzing events shall be held. 1. Titans of Trivia\u0096 The general quiz. 2. The MELA \u0096 Music, Entertainment, Literature and Art 3. The India Quiz 4. The Sports Quiz 5. The Business Quiz\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"quriosity\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 67,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Art Talkies\",\n    \t\"venue\": \"LHC 003\",\n    \t\"start_time\": \"14:30\",\n    \t\"end_time\": \"17:00\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Abhishek\",\n\t\t\"coord_no\": \"8076409102\",\n\t\t\"description\": \"In the modern era, the movies & their posters are highly digitized. Somewhere between this evolutions of cinema, a great form of human art was pushed to extinction. There is an unparalleled charisma in the posters of Mughal-e- azam, Sholay, Guide and even the one overseas Godfather, Marry Poppins & The sound of music. Let's bring this art-form back to life.Art Talkies invites folks to have an enriching experience at this on-the- spot poster making competition and witness the art meeting cinema.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"art_talkies\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 68,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Queen's Gambit\",\n    \t\"venue\": \"LHC 005\",\n    \t\"start_time\": \"14:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Amit\",\n\t\t\"coord_no\": \"8126116530\",\n\t\t\"description\": \"Do you pursuegood chess skills,but do not feel like playing those 30+minute games?If yes, then this is the best platform to show off your skills.Instead of playing tediously long matches on a chess board, this is a unique Chess tactics solving competition.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"queen_gambit\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 69,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Graph-O-Map Finals\",\n    \t\"venue\": \"LHC 003\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Tanmay\",\n\t\t\"coord_no\": \"8016267547\",\n\t\t\"description\": \"Calling all puzzle seekers, data enthusiasts and creative minds.Thomso, IIT Roorkee, brings to you an experience, tailor-made to satiate your innate desires to be like Sherlock Holmes. A competition that combines riddles, puzzles and data interpretation skills in a fun way. If you love the thrill and satisfaction of cracking puzzles, Graph-o-map is for you.The event will be held on 2 consecutive days during Thomso'17.Prizes worth 20k to be won.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 70,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Box Office\",\n    \t\"venue\": \"LHC 002\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"14:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Bhawna\",\n\t\t\"coord_no\": \"9711005447\",\n\t\t\"description\": \"This one\u0092s for the movie buffs. All those times you spent watching your beloved movies will finally pay off. This is the opportunity to showcase your skills.Be prepared to face an arsenal of movie related questions where you\u0092ll have to predict names of movies based on given hints.Unleash your creativity further and create a parody of a movie scene. Don\u0092t be afraid of being weird. Ordinary is always boring.Lights. Camera. Action. !\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"box_office\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 73,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Nukkad Natak Finals\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"09:00\",\n    \t\"end_time\": \"14:30\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Shivam Pal\",\n\t\t\"coord_no\": \"9012400090\",\n\t\t\"description\": \"Nukkad Natak is a street-play competition of Dramatics at Thomso where you speak in the lingo of the common folks to outline captivating issues which are also socially relevant. The main endeavor is to convey a social and political message in an entertaining environment, amidst the intimate and effective means of theatre by means of shout, chants, drums and catchy songs.This is your chance to be the change you think of bringing about.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"nukkad_natak\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 74,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Step Up Finals\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"15:00\",\n    \t\"end_time\": \"18:30\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Riya\",\n\t\t\"coord_no\": \"9759734528\",\n\t\t\"description\": \"Have you ever had the desire to express the hidden language of your soul, make the music visible and simply be insane? We'll provide you the level field to be fearless, limitless and well, as we promised before, insane. There are no spring floors, no spotlights, no stage, and no boundaries. Come on the streets to glide, to spin, to fly or to expression to all your instincts, bring your style on the floor. Dance on the random music being played and show your instincts to dance. Step-Up is an on-the- spot street dance competition.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"step_up\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 75,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Flash Mob\",\n    \t\"venue\": \"UG Floor\",\n    \t\"start_time\": \"14:30\",\n    \t\"end_time\": \"15:00\",\n    \t\"lat\": \"29.863737210131376\",\n    \t\"lng\": \"77.89465427398682\",\n\t\t\"coord\": \"Kanika\",\n\t\t\"coord_no\": \"8949670382\",\n\t\t\"description\": \"A flash mob is a group of people who assemble at a public place and perform an unusual and seemingly pointless act for a brief time for the purpose of entertainment and artistic expression and then they disperse. Its about doing something crazy and bizarre to entertain people around.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"flash_mob\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 77,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Aseem Trivedi-Interactive Session\",\n    \t\"venue\": \"LHC 006\",\n    \t\"start_time\": \"11:00\",\n    \t\"end_time\": \"13:30\",\n    \t\"lat\": \"29.8649204\",\n    \t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Satyendra\",\n\t\t\"coord_no\": \"9893415674\",\n\t\t\"description\": \"An interactive session with Aseem Trivedi, the famous cartoonist\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 78,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Entrepreneurship Quotient\",\n    \t\"venue\": \"LHC 102\",\n    \t\"start_time\": \"15:00\",\n    \t\"end_time\": \"17:00\",\n    \t\"lat\": \"29.8649204\",\n\t\t\"lng\": \"77.89380019999999\",\n\t\t\"coord\": \"Rahul\",\n\t\t\"coord_no\": \"9884848352\",\n\t\t\"description\": \"A quiz on entrepreneurship and startups.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\n\t},\t\n\t{\n\t\t \"id\": 80,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Silent DJ\",\n    \t\"venue\": \"SBI Lawn\",\n    \t\"start_time\": \"23:00\",\n    \t\"end_time\": \"03:00\",\n    \t\"lat\": \"29.8645778\",\n\t\t\"lng\": \"77.89564769999993\",\n\t\t\"coord\": \"Rohan Vadi\",\n\t\t\"coord_no\": \"9045900495\",\n\t\t\"description\": \" Silence isn\u0092t empty this time as music screams aloud. This Thomso experience live music in a unique way with SILENT DJ nights as dynamics of DJing flip into headphone tactics. Get ready to party all night as the silent disco gig makes bass go boom and beats go loud. Don\u0092t miss this one out as coolness is overloaded with the Silent DJ hitting the land of Magical Fantasia.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\n\t},\n\t{\n\t\t \"id\": 81,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Silent DJ\",\n    \t\"venue\": \"SBI Lawn\",\n    \t\"start_time\": \"23:00\",\n    \t\"end_time\": \"03:00\",\n    \t\"lat\": \"29.8645778\",\n\t\t\"lng\": \"77.89564769999993\",\n\t\t\"coord\": \"Rohan Vadi\",\n\t\t\"coord_no\": \"9045900495\",\n\t\t\"description\": \" Silence isn\u0092t empty this time as music screams aloud. This Thomso experience live music in a unique way with SILENT DJ nights as dynamics of DJing flip into headphone tactics. Get ready to party all night as the silent disco gig makes bass go boom and beats go loud. Don\u0092t miss this one out as coolness is overloaded with the Silent DJ hitting the land of Magical Fantasia.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\n\t},\n\t{\n\t\t \"id\": 82,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"Silent DJ\",\n    \t\"venue\": \"SBI Lawn\",\n    \t\"start_time\": \"23:00\",\n    \t\"end_time\": \"03:00\",\n    \t\"lat\": \"29.8645778\",\n\t\t\"lng\": \"77.89564769999993\",\n\t\t\"coord\": \"Rohan Vadi\",\n\t\t\"coord_no\": \"9045900495\",\n\t\t\"description\": \" Silence isn\u0092t empty this time as music screams aloud. This Thomso experience live music in a unique way with SILENT DJ nights as dynamics of DJing flip into headphone tactics. Get ready to party all night as the silent disco gig makes bass go boom and beats go loud. Don\u0092t miss this one out as coolness is overloaded with the Silent DJ hitting the land of Magical Fantasia.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 83,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"NightLife Cafe\",\n    \t\"venue\": \"OAT Swimming Pool\",\n    \t\"start_time\": \"23:00\",\n    \t\"end_time\": \"03:00\",\n    \t\"lat\": \"29.8663966\",\n\t\t\"lng\": \"77.89740119999999\",\n\t\t\"coord\": \"Agastya\",\n\t\t\"coord_no\": \"8266057084\",\n\t\t\"description\": \" Experience it yourself.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\n\t},\n\t{\n\t\t \"id\": 84,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"NightLife Cafe\",\n    \t\"venue\": \"OAT Swimming Pool\",\n    \t\"start_time\": \"23:00\",\n    \t\"end_time\": \"03:00\",\n    \t\"lat\": \"29.8663966\",\n\t\t\"lng\": \"77.89740119999999\",\n\t\t\"coord\": \"Agastya\",\n\t\t\"coord_no\": \"8266057084\",\n\t\t\"description\": \" Experience it yourself.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\n\t},\n\t{\n\t\t \"id\": 85,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"NightLife Cafe\",\n    \t\"venue\": \"OAT Swimming Pool\",\n    \t\"start_time\": \"23:00\",\n    \t\"end_time\": \"03:00\",\n    \t\"lat\": \"29.8663966\",\n\t\t\"lng\": \"77.89740119999999\",\n\t\t\"coord\": \"Agastya\",\n\t\t\"coord_no\": \"8266057084\",\n\t\t\"description\": \" Experience it yourself.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"\",\n\t\t\"day\": \"3\",\n\t\t\"date\": \"29-10-2017\"\n\t},\n\t{\n\t\t \"id\": 86,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"JunkYard Round 1\",\n    \t\"venue\": \"SDS Park\",\n    \t\"start_time\": \"14:30\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"\",\n\t\t\"lng\": \"\",\n\t\t\"coord\": \"Rajesh\",\n\t\t\"coord_no\": \"8860602347\",\n\t\t\"description\": \"'All Hands on the boat!!'' Well, as usual the \u0093Black Pearl\u0094 is gone, and our Dear Captain Sparrow is once again left behind on an island. Help Sparrow build a boat from the junk he is left with on the island, which will leads him towards the treasure far away in the Caribbean. Make use of the Junk made available to you to build a boat.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"junkyard\",\n\t\t\"day\": \"1\",\n\t\t\"date\": \"27-10-2017\"\n\t},\n\t{\n\t\t \"id\": 87,\n    \t \"event_id\": \"\",\n\t\t\"name\": \"JunkYard Round 2\",\n    \t\"venue\": \"OAT Swimming Pool\",\n    \t\"start_time\": \"14:30\",\n    \t\"end_time\": \"19:00\",\n    \t\"lat\": \"\",\n\t\t\"lng\": \"\",\n\t\t\"coord\": \"Rajesh\",\n\t\t\"coord_no\": \"8860602347\",\n\t\t\"description\": \"'All Hands on the boat!!' Well, as usual the \u0093Black Pearl\u0094 is gone, and our Dear Captain Sparrow is once again left behind on an island. Help Sparrow build a boat from the junk he is left with on the island, which will leads him towards the treasure far away in the Caribbean. Make use of the Junk made available to you to build a boat.\",\n\t\t\"image\": \"\",\n\t\t\"rulebook\": \"junkyard\",\n\t\t\"day\": \"2\",\n\t\t\"date\": \"28-10-2017\"\n\t}\n]";

    Menu menu;
    public ArrayList<event_object> day1=new ArrayList<event_object>();
    public ArrayList<event_object> day2=new ArrayList<event_object>();
    public ArrayList<event_object> day3=new ArrayList<event_object>();
    public ArrayList<event_object> on_going=new ArrayList<event_object>();

    SharedPreferences sharedpreferences;

    ImageLoader imageLoader;
    SharedPreferences.Editor editor;

    private ArrayList<Integer> rajansthanArray = new ArrayList<Integer>();
    private GridView gridView;
    private ArrayList<grid_item> grid_items=new ArrayList<grid_item>();
    int currentPage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        ImageView imageView=(ImageView)findViewById(R.id.home_image);
        Picasso.with(this).load(R.mipmap.background_home).into(imageView);


        sharedpreferences=getApplicationContext().getSharedPreferences(getString(R.string.pref_file),0);
        editor = sharedpreferences.edit();

          //  for_navigation();


        Utils nav=new Utils(this);



            // MainActivity.Async task=new MainActivity.Async();
        //task.execute();

        slide();
        String_to_event_list();

        gridView=(GridView)findViewById(R.id.home_gridView);

        grid_items.add(new grid_item(R.drawable.event, "Event", Event.class));
        grid_items.add(new grid_item(R.drawable.workshops, "Workshop", workshops.class));
        grid_items.add(new grid_item(R.drawable.guitar, "Pronites", pronites.class));
        grid_items.add(new grid_item(R.drawable.carnival, "Carnival", carnival_events.class));
        grid_items.add(new grid_item(R.drawable.litfest, "LITFest", lit_fest.class));
        grid_items.add(new grid_item(R.drawable.map, "Map", MapsActivity.class));
        grid_items.add(new grid_item(R.drawable.on_going, "On Going", on_going.class));
        grid_items.add(new grid_item(R.drawable.sponsor, "Sponsors", null));
        grid_items.add(new grid_item(R.drawable.team, "Team", team.class));


        final adapter_gridview adapter = new adapter_gridview(MainActivity.this, grid_items);
        gridView.setAdapter(adapter);

       /* FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.test_float);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentActivity(v);
            }
        });
*/


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //    if(bank_accounts!=null){
                grid_item item = adapter.getItem(position);

                Class s = item.getActivity();
               if(s==null){

                   String url=getResources().getString(R.string.base_url)+"sponsors";
                   CustomTabsIntent.Builder builder=new CustomTabsIntent.Builder();
                   CustomTabsIntent customTabsIntent=builder.build();
                   customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
                   builder.setToolbarColor(R.color.grey);
                   return;
               }


                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,view,"transition");

                int[] loc=new int[2];
                view.getLocationOnScreen(loc);
               // int revealX = (int) (view.getScaleX() + view.getWidth() / 2);
                //int revealY = (int) (view.getScaleY() + view.getHeight() / 2);

                int revealX=loc[0];
                int revealY=loc[1];

                Intent intent = new Intent(MainActivity.this, s);
                intent.putExtra(getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_X), revealX);
                intent.putExtra(getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_Y), revealY);

                //startActivity(intent);
                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());


            }
        });
        setupmenu();

    }
    FlowingDrawer mflowing;
    private void setupmenu() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mflowing=(FlowingDrawer)findViewById(R.id.flowing_drawer_layout);
        mflowing.setTouchMode(ElasticDrawer.TOUCH_MODE_FULLSCREEN);

        Drawable drawable= getResources().getDrawable(R.drawable.menu);

        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Drawable newdrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap,56, 56, true));

        toolbar.setNavigationIcon(newdrawable);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mflowing.openMenu();
            }
        });
        //
        if (Build.VERSION.SDK_INT <Build.VERSION_CODES.LOLLIPOP) {

        } else {
            toolbar.setElevation(0);
        }


            android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        floating_menu menu=(floating_menu)fm.findFragmentById(R.id.flowing_menu);

        if(menu==null){
            menu=new floating_menu();
            fm.beginTransaction().add(R.id.flowing_menu,menu).commit();
        }

    }


    private void String_to_event_list(){
        try {
            JSONArray list= new JSONArray(events);
            for (int i = 0; i < list.length(); i++) {
                JSONObject event = list.getJSONObject(i);
                String id=event.getString("event_id");
                String name=event.getString("name") ;
                String venue=event.getString("venue");
                String start_time=event.getString("start_time");
                String end_time=event.getString("end_time");
                String lat=event.getString("lat");
                String lng=event.getString("lng");
                String coord=event.getString("coord");
                String coord_no=event.getString("coord_no");
                String description=event.getString("description");
                String rulebook=event.getString("rulebook");
                String day=event.getString("day");
                String date=event.getString("date");

              if(day.contains("1")){
                  day1.add(new event_object(id,name,venue,start_time,end_time,lat,lng,coord,coord_no,description,rulebook,day,date));
              }else if (day.contains("2")){
                  day2.add(new event_object(id,name,venue,start_time,end_time,lat,lng,coord,coord_no,description,rulebook,day,date));
              }else if(day.contains("3")){
                  day3.add(new event_object(id,name,venue,start_time,end_time,lat,lng,coord,coord_no,description,rulebook,day,date));
              }

              if(going_check(date,start_time,end_time)){
                  on_going.add(new event_object(id,name,venue,start_time,end_time,lat,lng,coord,coord_no,description,rulebook,day,date));
              }


            }
        } catch(JSONException e){
            e.printStackTrace();
            }
        Gson gson=new Gson();

        Collections.sort(day1, new CustomComparator());
        Collections.sort(day2, new CustomComparator());
        Collections.sort(day3, new CustomComparator());
        Collections.sort(on_going, new reverse_CustomComparator());

        String json1=gson.toJson(day1);
        String json2=gson.toJson(day2);
        String json3=gson.toJson(day3);
        String json_going=gson.toJson(on_going);

        editor.putString(getResources().getString(R.string.day_1),json1);
        editor.putString(getResources().getString(R.string.day_2),json2);
        editor.putString(getResources().getString(R.string.day_3),json3);
        editor.putString(getResources().getString(R.string.on_going),json_going);
        editor.commit();


    }

    private boolean going_check(String date, String start_time, String end_time) {
        Calendar calendar3 = Calendar.getInstance();
        SimpleDateFormat df_date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat df_time = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = df_date.format(calendar3.getTime());
        String formattedtime = df_time.format(calendar3.getTime());

        if(formattedDate.contains(date.substring(0,4)))
        try {
            String string1 = start_time+":00";
            Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);

            String string2 = end_time+":00";
            Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.MINUTE, 30);

            Date d = new SimpleDateFormat("HH:mm:ss").parse(formattedtime);
            calendar3.setTime(d);

            Date x = calendar3.getTime();

            if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {

                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;


    }

    public class CustomComparator implements Comparator<event_object> {
        @Override
        public int compare(event_object o1, event_object o2) {
            return (o1.getStart_time()+o1.getEnd_time()).compareTo(o2.getStart_time()+o2.getEnd_time());
        }
    }
    public class reverse_CustomComparator implements Comparator<event_object> {
        @Override
        public int compare(event_object o2, event_object o1) {
            return (o1.getStart_time()+o1.getEnd_time()).compareTo(o2.getStart_time()+o2.getEnd_time());
        }
    }

    private void slide() {
        for(int i=0;i<rajasthan.length;i++) {
            rajansthanArray.add(rajasthan[i]);
        }

        final ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new adapter_slider(MainActivity.this,rajansthanArray));



        CircleIndicator indicator=(CircleIndicator)findViewById(R.id.circel_indicator);
        indicator.setViewPager(viewPager);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == rajasthan.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 2000);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu=menu;
        getMenuInflater().inflate(R.menu.main, menu);
        if(!sharedpreferences.getBoolean(getResources().getString(R.string.user_auth),false)){
            MenuItem log=menu.findItem(R.id.action_out);
            log.setTitle("Log In");
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_faq) {
            String url=getResources().getString(R.string.base_url)+"faq";
            CustomTabsIntent.Builder builder=new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent=builder.build();
            customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
            builder.setToolbarColor(R.color.grey);
            return true;
        }else   if (id == R.id.action_out) {
            editor.clear();
            editor.commit();
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }else   if (id == R.id.action_profile) {
            if(sharedpreferences.getBoolean(getResources().getString(R.string.user_auth),false)) {
                Intent intent=new Intent(MainActivity.this,Profile.class);
                startActivity(intent);
            }else {
                Toast.makeText(this,"Please Login",Toast.LENGTH_LONG).show();
            }
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    public void presentActivity(View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "transition");
        int revealX = (int) (view.getX() + view.getWidth() / 2);
        int revealY = (int) (view.getY() + view.getHeight() / 2);

        Intent intent = new Intent(this, registered_events.class);
        intent.putExtra(getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_X), revealX);
        intent.putExtra(getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_Y), revealY);

        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

}
