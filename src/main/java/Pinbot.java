import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


import java.time.LocalDate;


import java.time.LocalDateTime;
import java.util.EnumSet;

import org.nibor.autolink.*;


public class Pinbot extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String msg = event.getMessage().getContentRaw();
        String theuser = event.getMember().getEffectiveName();
        String theid = event.getMember().getUser().getId();
        TextChannel channel = event.getTextChannel();


        String input = msg;
        LinkExtractor linkExtractor = LinkExtractor.builder()
                .linkTypes(EnumSet.of(LinkType.URL, LinkType.WWW, LinkType.EMAIL))
                .build();
        Iterable<LinkSpan> links = linkExtractor.extractLinks(input);
        LinkSpan link = links.iterator().next();
        link.getType();        // LinkType.URL
        link.getBeginIndex();  // 17
        link.getEndIndex();    // 32

        String url = input.substring(link.getBeginIndex(), link.getEndIndex());




        if (msg.contains("youtube.com/") || msg.contains("youtu.be")) {

            if (msg.contains(Settings.getRoleone())) {



                System.out.println(theuser + " " + Settings.getPretextone() + " " + theid + " " + LocalDateTime.now());
                channel.getManager().setTopic(Settings.getPretextone() + " " + LocalDate.now() + " " + "|" + " " + url).queue();


            }


            if (msg.contains(Settings.getRoletwo())) {

                System.out.println(theuser + " " + Settings.getPretexttwo() + " " + theid + " " + LocalDateTime.now());
                channel.getManager().setTopic(Settings.getPretexttwo() + " " + LocalDate.now() + " " + "|" + " " + url).queue();
            }

            if(msg.contains(Settings.getRolethree())) {
                System.out.println(theuser + " " + Settings.getPretextthree() + " " + theid + " " + LocalDateTime.now());
                channel.getManager().setTopic(Settings.getPretextthree() + " " + LocalDate.now() + " " + "|" + " " + url).queue();
            }

        }

    }
}
