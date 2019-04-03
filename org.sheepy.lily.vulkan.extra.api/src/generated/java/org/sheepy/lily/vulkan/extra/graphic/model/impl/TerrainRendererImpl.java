/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage;
import org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider;
import org.sheepy.lily.vulkan.extra.graphic.model.TerrainRenderer;

import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terrain Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.TerrainRendererImpl#getMeshProvider <em>Mesh Provider</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TerrainRendererImpl extends GraphicsPipelineImpl implements TerrainRenderer
{
	/**
	 * The cached value of the '{@link #getMeshProvider() <em>Mesh Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeshProvider()
	 * @generated
	 * @ordered
	 */
	protected IMeshProvider meshProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerrainRendererImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicExtraPackage.Literals.TERRAIN_RENDERER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IMeshProvider getMeshProvider()
	{
		if (meshProvider != null && meshProvider.eIsProxy())
		{
			InternalEObject oldMeshProvider = (InternalEObject) meshProvider;
			meshProvider = (IMeshProvider) eResolveProxy(oldMeshProvider);
			if (meshProvider != oldMeshProvider)
			{
				if (eNotificationRequired()) eNotify(new ENotificationImpl(this,
						Notification.RESOLVE, GraphicExtraPackage.TERRAIN_RENDERER__MESH_PROVIDER,
						oldMeshProvider, meshProvider));
			}
		}
		return meshProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMeshProvider basicGetMeshProvider()
	{
		return meshProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeshProvider(IMeshProvider newMeshProvider)
	{
		IMeshProvider oldMeshProvider = meshProvider;
		meshProvider = newMeshProvider;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicExtraPackage.TERRAIN_RENDERER__MESH_PROVIDER, oldMeshProvider,
				meshProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
		case GraphicExtraPackage.TERRAIN_RENDERER__MESH_PROVIDER:
			if (resolve) return getMeshProvider();
			return basicGetMeshProvider();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case GraphicExtraPackage.TERRAIN_RENDERER__MESH_PROVIDER:
			setMeshProvider((IMeshProvider) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
		case GraphicExtraPackage.TERRAIN_RENDERER__MESH_PROVIDER:
			setMeshProvider((IMeshProvider) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
		case GraphicExtraPackage.TERRAIN_RENDERER__MESH_PROVIDER:
			return meshProvider != null;
		}
		return super.eIsSet(featureID);
	}

} //TerrainRendererImpl
