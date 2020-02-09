/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToPush <em>Used To Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToFetch <em>Used To Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforePush <em>Stage Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforePush <em>Access Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforeFetch <em>Stage Before Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforeFetch <em>Access Before Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowThreshold <em>Grow Threshold</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getMinSize <em>Min Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getRequestedSize <em>Requested Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider()
 * @model
 * @generated
 */
public interface BufferDataProvider<T> extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' containment reference.
	 * @see #setDataSource(Object)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_DataSource()
	 * @model kind="reference" containment="true"
	 * @generated
	 */
	T getDataSource();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getDataSource <em>Data Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' containment reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(T value);

	/**
	 * Returns the value of the '<em><b>Used To Push</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used To Push</em>' attribute.
	 * @see #setUsedToPush(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_UsedToPush()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isUsedToPush();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToPush <em>Used To Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used To Push</em>' attribute.
	 * @see #isUsedToPush()
	 * @generated
	 */
	void setUsedToPush(boolean value);

	/**
	 * Returns the value of the '<em><b>Used To Fetch</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used To Fetch</em>' attribute.
	 * @see #setUsedToFetch(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_UsedToFetch()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUsedToFetch();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToFetch <em>Used To Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used To Fetch</em>' attribute.
	 * @see #isUsedToFetch()
	 * @generated
	 */
	void setUsedToFetch(boolean value);

	/**
	 * Returns the value of the '<em><b>Stage Before Push</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage Before Push</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setStageBeforePush(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_StageBeforePush()
	 * @model
	 * @generated
	 */
	EPipelineStage getStageBeforePush();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforePush <em>Stage Before Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage Before Push</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getStageBeforePush()
	 * @generated
	 */
	void setStageBeforePush(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Access Before Push</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Before Push</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_AccessBeforePush()
	 * @model
	 * @generated
	 */
	EList<EAccess> getAccessBeforePush();

	/**
	 * Returns the value of the '<em><b>Stage Before Fetch</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage Before Fetch</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setStageBeforeFetch(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_StageBeforeFetch()
	 * @model
	 * @generated
	 */
	EPipelineStage getStageBeforeFetch();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforeFetch <em>Stage Before Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage Before Fetch</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getStageBeforeFetch()
	 * @generated
	 */
	void setStageBeforeFetch(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Access Before Fetch</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Before Fetch</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_AccessBeforeFetch()
	 * @model
	 * @generated
	 */
	EList<EAccess> getAccessBeforeFetch();

	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_Usages()
	 * @model
	 * @generated
	 */
	EList<EBufferUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EInstanceCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #setInstanceCount(EInstanceCount)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_InstanceCount()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EInstanceCount getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(EInstanceCount value);

	/**
	 * Returns the value of the '<em><b>Grow Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Factor</em>' attribute.
	 * @see #setGrowFactor(float)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_GrowFactor()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowFactor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowFactor <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grow Factor</em>' attribute.
	 * @see #getGrowFactor()
	 * @generated
	 */
	void setGrowFactor(float value);

	/**
	 * Returns the value of the '<em><b>Grow Threshold</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Threshold</em>' attribute.
	 * @see #setGrowThreshold(float)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_GrowThreshold()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowThreshold();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowThreshold <em>Grow Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grow Threshold</em>' attribute.
	 * @see #getGrowThreshold()
	 * @generated
	 */
	void setGrowThreshold(float value);

	/**
	 * Returns the value of the '<em><b>Min Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Size</em>' attribute.
	 * @see #setMinSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_MinSize()
	 * @model default="0" required="true"
	 * @generated
	 */
	long getMinSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getMinSize <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Size</em>' attribute.
	 * @see #getMinSize()
	 * @generated
	 */
	void setMinSize(long value);

	/**
	 * Returns the value of the '<em><b>Requested Size</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requested Size</em>' attribute.
	 * @see #setRequestedSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferDataProvider_RequestedSize()
	 * @model default="1" required="true"
	 * @generated
	 */
	long getRequestedSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getRequestedSize <em>Requested Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requested Size</em>' attribute.
	 * @see #getRequestedSize()
	 * @generated
	 */
	void setRequestedSize(long value);

} // BufferDataProvider
