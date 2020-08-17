#version 450

layout (constant_id = 0) const int textureCount = 1;

precision lowp float;

layout (binding = 0) uniform sampler2D nullTexture;
layout (binding = 1) uniform sampler fontSampler;
layout (binding = 2) uniform sampler textureSampler;
layout (binding = 3) uniform texture2D textures[textureCount + 1];

layout (push_constant) uniform PushConstants {
	mat4 ProjMtx;
	int descriptorId;
} pushConstants;

layout (location = 0) in vec2 Frag_UV;
layout (location = 1) in vec4 Frag_Color;

layout (location = 0) out vec4 outColor;

void main()
{
  const int index = pushConstants.descriptorId;
  if (index == 0)
	outColor = Frag_Color * texture(nullTexture, Frag_UV.st);
  else if (index == 1)
	outColor = vec4(Frag_Color.rgb, Frag_Color.a * texture(sampler2D(textures[0], fontSampler), Frag_UV.st));
  else
	outColor = texture(sampler2D(textures[index - 1], textureSampler), Frag_UV.st);
}
