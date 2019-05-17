#version 450
#extension GL_ARB_separate_shader_objects : enable

precision mediump float;

layout (binding = 0) uniform sampler2D texture1;
layout (binding = 1) uniform sampler2D texture2;

layout (push_constant) uniform PushConstants {
	mat4 ProjMtx;
	int descriptorId;
} pushConstants;

layout (location = 0) in vec2 Frag_UV;
layout (location = 1) in vec4 Frag_Color;

layout (location = 0) out vec4 Out_Color;

void main(){
  if(pushConstants.descriptorId == 0)
    Out_Color = Frag_Color * texture(texture1, Frag_UV.st);
  else
    Out_Color = Frag_Color * texture(texture2, Frag_UV.st);
}
