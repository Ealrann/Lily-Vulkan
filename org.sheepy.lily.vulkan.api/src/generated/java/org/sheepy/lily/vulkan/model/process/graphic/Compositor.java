/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.application.ICompositor;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.variable.ModelVariablePkg;

import org.sheepy.lily.vulkan.model.DescriptorPkg;

import org.sheepy.lily.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compositor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getVertexShader <em>Vertex Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getFragmentShader <em>Fragment Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getColorAttachments <em>Color Attachments</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getInputAttachments <em>Input Attachments</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getConstantVariables <em>Constant Variables</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getDescriptorPkg <em>Descriptor Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getCompositor()
 * @model
 * @generated
 */
public interface Compositor extends ICompositor, LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Vertex Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Shader</em>' reference.
	 * @see #setVertexShader(Shader)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getCompositor_VertexShader()
	 * @model required="true"
	 * @generated
	 */
	Shader getVertexShader();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getVertexShader <em>Vertex Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Shader</em>' reference.
	 * @see #getVertexShader()
	 * @generated
	 */
	void setVertexShader(Shader value);

	/**
	 * Returns the value of the '<em><b>Fragment Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment Shader</em>' reference.
	 * @see #setFragmentShader(Shader)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getCompositor_FragmentShader()
	 * @model required="true"
	 * @generated
	 */
	Shader getFragmentShader();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getFragmentShader <em>Fragment Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment Shader</em>' reference.
	 * @see #getFragmentShader()
	 * @generated
	 */
	void setFragmentShader(Shader value);

	/**
	 * Returns the value of the '<em><b>Color Attachments</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.Attachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Attachments</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getCompositor_ColorAttachments()
	 * @model required="true"
	 * @generated
	 */
	EList<Attachment> getColorAttachments();

	/**
	 * Returns the value of the '<em><b>Input Attachments</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Attachments</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getCompositor_InputAttachments()
	 * @model
	 * @generated
	 */
	EList<ExtraAttachment> getInputAttachments();

	/**
	 * Returns the value of the '<em><b>Constant Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Variables</em>' containment reference.
	 * @see #setConstantVariables(ModelVariablePkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getCompositor_ConstantVariables()
	 * @model containment="true"
	 * @generated
	 */
	ModelVariablePkg getConstantVariables();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getConstantVariables <em>Constant Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Variables</em>' containment reference.
	 * @see #getConstantVariables()
	 * @generated
	 */
	void setConstantVariables(ModelVariablePkg value);

	/**
	 * Returns the value of the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Pkg</em>' containment reference.
	 * @see #setDescriptorPkg(DescriptorPkg)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getCompositor_DescriptorPkg()
	 * @model containment="true"
	 * @generated
	 */
	DescriptorPkg getDescriptorPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.Compositor#getDescriptorPkg <em>Descriptor Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Pkg</em>' containment reference.
	 * @see #getDescriptorPkg()
	 * @generated
	 */
	void setDescriptorPkg(DescriptorPkg value);

} // Compositor
