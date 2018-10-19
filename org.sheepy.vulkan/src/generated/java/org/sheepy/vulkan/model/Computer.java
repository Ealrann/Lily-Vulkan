/**
 */
package org.sheepy.vulkan.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.Computer#getShader <em>Shader</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.VulkanPackage#getComputer()
 * @model
 * @generated
 */
public interface Computer extends IProcessUnit
{

	/**
	 * Returns the value of the '<em><b>Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shader</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shader</em>' reference.
	 * @see #setShader(Shader)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getComputer_Shader()
	 * @model
	 * @generated
	 */
	Shader getShader();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.Computer#getShader <em>Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shader</em>' reference.
	 * @see #getShader()
	 * @generated
	 */
	void setShader(Shader value);
} // Computer
