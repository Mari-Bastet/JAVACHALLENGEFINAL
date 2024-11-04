package fiap.br.challenge.repository;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.model.Model;

@FunctionalInterface
public interface ImageModel extends Model<ImagePrompt, ImageResponse> {

	ImageResponse call(ImagePrompt request);

}