/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getShader <em>Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getWorkgroupCountX <em>Workgroup Count X</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getWorkgroupCountY <em>Workgroup Count Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getWorkgroupCountZ <em>Workgroup Count Z</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputer()
 * @model
 * @generated
 */
public interface Computer extends IPipelineTask
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
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputer_Shader()
	 * @model
	 * @generated
	 */
	Shader getShader();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getShader <em>Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shader</em>' reference.
	 * @see #getShader()
	 * @generated
	 */
	void setShader(Shader value);

	/**
	 * Returns the value of the '<em><b>Workgroup Count X</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Count X</em>' attribute.
	 * @see #setWorkgroupCountX(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputer_WorkgroupCountX()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getWorkgroupCountX();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getWorkgroupCountX <em>Workgroup Count X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Count X</em>' attribute.
	 * @see #getWorkgroupCountX()
	 * @generated
	 */
	void setWorkgroupCountX(int value);

	/**
	 * Returns the value of the '<em><b>Workgroup Count Y</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Count Y</em>' attribute.
	 * @see #setWorkgroupCountY(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputer_WorkgroupCountY()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getWorkgroupCountY();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getWorkgroupCountY <em>Workgroup Count Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Count Y</em>' attribute.
	 * @see #getWorkgroupCountY()
	 * @generated
	 */
	void setWorkgroupCountY(int value);

	/**
	 * Returns the value of the '<em><b>Workgroup Count Z</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Count Z</em>' attribute.
	 * @see #setWorkgroupCountZ(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputer_WorkgroupCountZ()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getWorkgroupCountZ();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.Computer#getWorkgroupCountZ <em>Workgroup Count Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Count Z</em>' attribute.
	 * @see #getWorkgroupCountZ()
	 * @generated
	 */
	void setWorkgroupCountZ(int value);

} // Computer
