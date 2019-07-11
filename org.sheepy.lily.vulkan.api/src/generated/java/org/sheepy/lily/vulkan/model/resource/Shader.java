/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shader</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Shader#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Shader#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Shader#getConstants <em>Constants</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getShader()
 * @model
 * @generated
 */
public interface Shader extends BasicResource
{
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference.
	 * @see #setFile(PathResource)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getShader_File()
	 * @model containment="true"
	 * @generated
	 */
	PathResource getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Shader#getFile <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' containment reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(PathResource value);

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see #setStage(EShaderStage)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getShader_Stage()
	 * @model unique="false"
	 * @generated
	 */
	EShaderStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Shader#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(EShaderStage value);

	/**
	 * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.pipeline.SpecializationConstant}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constants</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getShader_Constants()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<SpecializationConstant> getConstants();

} // Shader
