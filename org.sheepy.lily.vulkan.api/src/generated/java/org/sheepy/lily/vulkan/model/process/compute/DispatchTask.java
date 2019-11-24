/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dispatch Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountX <em>Workgroup Count X</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountY <em>Workgroup Count Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountZ <em>Workgroup Count Z</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getDispatchTask()
 * @model
 * @generated
 */
public interface DispatchTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Workgroup Count X</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Count X</em>' attribute.
	 * @see #setWorkgroupCountX(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getDispatchTask_WorkgroupCountX()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getWorkgroupCountX();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountX <em>Workgroup Count X</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getDispatchTask_WorkgroupCountY()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getWorkgroupCountY();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountY <em>Workgroup Count Y</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getDispatchTask_WorkgroupCountZ()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getWorkgroupCountZ();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountZ <em>Workgroup Count Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Count Z</em>' attribute.
	 * @see #getWorkgroupCountZ()
	 * @generated
	 */
	void setWorkgroupCountZ(int value);

} // DispatchTask
