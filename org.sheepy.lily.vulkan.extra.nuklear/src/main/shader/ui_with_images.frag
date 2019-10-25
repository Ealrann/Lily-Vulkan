#version 450

layout (constant_id = 0) const int imageCount = 1;

precision lowp float;

layout (binding = 0) uniform sampler2D texture1;
layout (binding = 1) uniform sampler2D texture2;
layout (binding = 2) uniform sampler samp;
layout (binding = 3) uniform texture2D textures[imageCount];

layout (push_constant) uniform PushConstants {
	mat4 ProjMtx;
	int descriptorId;
} pushConstants;

layout (location = 0) in vec2 Frag_UV;
layout (location = 1) in vec4 Frag_Color;

layout (location = 0) out vec4 outColor;

void main()
{
  int index = pushConstants.descriptorId;
  if (index == 0)
	outColor = Frag_Color * texture(texture1, Frag_UV.st);
  else if (index == 1)
	outColor = Frag_Color * texture(texture2, Frag_UV.st);
  else
	outColor = texture(sampler2D(textures[index - 2], samp), Frag_UV.st);
}
