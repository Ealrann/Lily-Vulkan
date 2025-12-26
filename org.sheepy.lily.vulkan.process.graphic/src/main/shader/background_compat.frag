#version 450

layout (input_attachment_index = 0, binding = 0) uniform subpassInput inputColor;

layout (location = 0) out vec4 outColor;


void main()
{
    // Read color from previous color input attachment
    vec3 color = subpassLoad(inputColor).rgb;
    outColor.rgb = color;
}
