/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getUsage <em>Usage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToPush <em>Used To Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToFetch <em>Used To Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforePush <em>Stage Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforePush <em>Access Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforeFetch <em>Stage Before Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforeFetch <em>Access Before Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowThreshold <em>Grow Threshold</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider()
 * @model
 * @generated
 */
public interface BufferDataProvider<T> extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Usage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see #setUsage(EBufferUsage)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_Usage()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EBufferUsage getUsage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getUsage <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see #getUsage()
	 * @generated
	 */
	void setUsage(EBufferUsage value);

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see #setInstanceCount(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_InstanceCount()
	 * @model default="1" unique="false" required="true"
	 * @generated
	 */
	int getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(int value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' containment reference.
	 * @see #setDataSource(Object)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_DataSource()
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_UsedToPush()
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_UsedToFetch()
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_StageBeforePush()
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_AccessBeforePush()
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_StageBeforeFetch()
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_AccessBeforeFetch()
	 * @model
	 * @generated
	 */
	EList<EAccess> getAccessBeforeFetch();

	/**
	 * Returns the value of the '<em><b>Grow Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Factor</em>' attribute.
	 * @see #setGrowFactor(float)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_GrowFactor()
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_GrowThreshold()
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

} // BufferDataProvider
