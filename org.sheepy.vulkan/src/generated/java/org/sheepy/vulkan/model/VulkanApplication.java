/**
 */
package org.sheepy.vulkan.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.common.api.types.SVector2i;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#isDebug <em>Debug</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#getComputePools <em>Compute Pools</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.VulkanApplication#getGraphicPool <em>Graphic Pool</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication()
 * @model
 * @generated
 */
public interface VulkanApplication extends EObject
{
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_Enabled()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanApplication#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Fullscreen</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fullscreen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fullscreen</em>' attribute.
	 * @see #setFullscreen(boolean)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_Fullscreen()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isFullscreen();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanApplication#isFullscreen <em>Fullscreen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fullscreen</em>' attribute.
	 * @see #isFullscreen()
	 * @generated
	 */
	void setFullscreen(boolean value);

	/**
	 * Returns the value of the '<em><b>Resizeable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resizeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resizeable</em>' attribute.
	 * @see #setResizeable(boolean)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_Resizeable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isResizeable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanApplication#isResizeable <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resizeable</em>' attribute.
	 * @see #isResizeable()
	 * @generated
	 */
	void setResizeable(boolean value);

	/**
	 * Returns the value of the '<em><b>Debug</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debug</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug</em>' attribute.
	 * @see #setDebug(boolean)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_Debug()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isDebug();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanApplication#isDebug <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug</em>' attribute.
	 * @see #isDebug()
	 * @generated
	 */
	void setDebug(boolean value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_Title()
	 * @model unique="false"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanApplication#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(SVector2i)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_Size()
	 * @model unique="false" dataType="org.sheepy.common.model.types.SVector2i"
	 * @generated
	 */
	SVector2i getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanApplication#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(SVector2i value);

	/**
	 * Returns the value of the '<em><b>Compute Pools</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.ComputeProcessPool}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compute Pools</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compute Pools</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_ComputePools()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputeProcessPool> getComputePools();

	/**
	 * Returns the value of the '<em><b>Graphic Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphic Pool</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphic Pool</em>' containment reference.
	 * @see #setGraphicPool(GraphicProcessPool)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getVulkanApplication_GraphicPool()
	 * @model containment="true"
	 * @generated
	 */
	GraphicProcessPool getGraphicPool();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.VulkanApplication#getGraphicPool <em>Graphic Pool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphic Pool</em>' containment reference.
	 * @see #getGraphicPool()
	 * @generated
	 */
	void setGraphicPool(GraphicProcessPool value);

} // VulkanApplication
