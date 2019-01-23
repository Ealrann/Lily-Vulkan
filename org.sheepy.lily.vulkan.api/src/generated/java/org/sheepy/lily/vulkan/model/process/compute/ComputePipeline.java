/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.sheepy.lily.vulkan.model.process.AbstractPipeline;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeX <em>Workgroup Size X</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeY <em>Workgroup Size Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeZ <em>Workgroup Size Z</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getDepth <em>Depth</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline()
 * @model
 * @generated
 */
public interface ComputePipeline extends AbstractPipeline
{
	/**
	 * Returns the value of the '<em><b>Workgroup Size X</b></em>' attribute.
	 * The default value is <code>"32"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workgroup Size X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Size X</em>' attribute.
	 * @see #setWorkgroupSizeX(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline_WorkgroupSizeX()
	 * @model default="32" unique="false"
	 * @generated
	 */
	int getWorkgroupSizeX();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeX <em>Workgroup Size X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Size X</em>' attribute.
	 * @see #getWorkgroupSizeX()
	 * @generated
	 */
	void setWorkgroupSizeX(int value);

	/**
	 * Returns the value of the '<em><b>Workgroup Size Y</b></em>' attribute.
	 * The default value is <code>"32"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workgroup Size Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Size Y</em>' attribute.
	 * @see #setWorkgroupSizeY(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline_WorkgroupSizeY()
	 * @model default="32" unique="false"
	 * @generated
	 */
	int getWorkgroupSizeY();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeY <em>Workgroup Size Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Size Y</em>' attribute.
	 * @see #getWorkgroupSizeY()
	 * @generated
	 */
	void setWorkgroupSizeY(int value);

	/**
	 * Returns the value of the '<em><b>Workgroup Size Z</b></em>' attribute.
	 * The default value is <code>"32"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workgroup Size Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workgroup Size Z</em>' attribute.
	 * @see #setWorkgroupSizeZ(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline_WorkgroupSizeZ()
	 * @model default="32" unique="false"
	 * @generated
	 */
	int getWorkgroupSizeZ();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeZ <em>Workgroup Size Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workgroup Size Z</em>' attribute.
	 * @see #getWorkgroupSizeZ()
	 * @generated
	 */
	void setWorkgroupSizeZ(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline_Width()
	 * @model unique="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline_Height()
	 * @model unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(int)
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#getComputePipeline_Depth()
	 * @model unique="false"
	 * @generated
	 */
	int getDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(int value);

} // ComputePipeline
