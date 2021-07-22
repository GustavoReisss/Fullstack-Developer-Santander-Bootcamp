import java.util.stream.Collectors;

public class StringLinesExemplos {
    
    public static void main(String[] args) {
        String html = "<html>\n    <head>\n\n    </head>\n    <body>\n\n    </body\n</html>";
        
        
        // Lines com .filter e Collectors.joining()
        System.out.println(html.lines().filter(s -> s.contains("head")).collect(Collectors.joining()));
        // Saída:    <head>    </head> 
        
        
        // Lines com .map e Collectors.joining()
        System.out.println(html.lines().map(s -> "[TAG]: " + s).collect(Collectors.joining()));
        // Saída: [TAG]: <html>[TAG]:     <head>[TAG]: [TAG]:     </head>[TAG]:     <body>[TAG]: [TAG]:     </body[TAG]: </html>
    
        
        // Lines com .map e Collectors.toList()
        System.out.println(html.lines().map(s -> "[TAG]: " + s).collect(Collectors.toList()));
        // Saída: [[TAG]: <html>, [TAG]:     <head>, [TAG]: , [TAG]:     </head>, [TAG]:     <body>, [TAG]: , [TAG]:     </body, [TAG]: </html>]
    }  
}
